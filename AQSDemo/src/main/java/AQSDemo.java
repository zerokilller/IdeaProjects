import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 *AQS深度解析
 */
public class AQSDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        //带入一个银行办理业务的案例来模拟我们的AQS如何进行线程的管理和通知唤醒机制。
        //3个线程模拟3个来银行网点，受理窗口办理业务的顾客。
        
        //第一个顾客
        new Thread(() ->{
            lock.lock();
            try{
                System.out.println(Thread.currentThread().getName()+ "\t" + "A thread come in");
                try{ TimeUnit.MINUTES.sleep(20);}catch(InterruptedException e){e.printStackTrace();}
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                lock.unlock();
            }
        },"A").start();

        //第二个顾客,第二个线程，由于受理业务的窗口只有一个(只能有一个线程持有锁),此时B只能等待,
        //进入候客区。
        new Thread(() ->{
            lock.lock();
            try{
                System.out.println(Thread.currentThread().getName()+ "\t" + "B thread come in");
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                lock.unlock();
            }
        },"B").start();

        //第三个顾客,第三个线程，由于受理业务的窗口只有一个(只能有一个线程持有锁),此时C只能等待,
        //进入候客区。
        new Thread(() ->{
            lock.lock();
            try{
                System.out.println(Thread.currentThread().getName()+ "\t" + "C thread come in");
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                lock.unlock();
            }
        },"C").start();
    }
}
