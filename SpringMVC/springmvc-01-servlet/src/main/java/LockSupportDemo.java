import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 */

public class LockSupportDemo {
    static Object lockObject = new Object();
    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static void main(String[] args) {
       Thread a = new Thread(()->{
           System.out.println(Thread.currentThread().getName()+"\t"+"---------come in");
           LockSupport.park();//当前线程被阻塞.........等待通知，等待放行,他要通过需要许可证。
           System.out.println(Thread.currentThread().getName()+"\t"+"---------被唤醒");
       },"a");
       a.start();
       try{ TimeUnit.SECONDS.sleep(3);}catch(InterruptedException e){e.printStackTrace();}
       Thread b = new Thread(()->{
           LockSupport.unpark(a);
           System.out.println(Thread.currentThread().getName()+"\t"+"---------通知");
        },"b");
       b.start();
    }
    public static void main2(String[] args) {
        new Thread(() ->{
            lock.lock();
            try{
                System.out.println(Thread.currentThread().getName()+"\t"+"----------come in");
                try{
                    condition.await();
                }catch(Exception e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"\t"+"----------被唤醒");
            }finally{
                lock.unlock();
            }
        },"A").start();
        new Thread(() ->{
            lock.lock();
            try{
                condition.signal();
                System.out.println(Thread.currentThread().getName()+"\t"+"----------通知");
            }finally {
                lock.unlock();
            }
        },"B").start();
    }
    public static void main1(String[] args) {
        new Thread(() ->{
            synchronized(lockObject){
                System.out.println(Thread.currentThread().getName()+"\t"+"----------come in");
                try{
                    lockObject.wait();
                }catch(Exception e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"\t"+"----------被唤醒");
            }
        },"t1").start();
        new Thread(() ->{
            synchronized (lockObject){
                lockObject.notify();
                System.out.println(Thread.currentThread().getName()+"\t"+"----------通知");
            }
        },"t2").start();
    }
}
