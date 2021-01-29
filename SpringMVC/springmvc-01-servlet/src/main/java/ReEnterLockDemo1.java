
/**
 *可重入锁:可重复可递归调用的锁，在外层使用锁之后，在内层仍然可以使用，并且不发生死锁，这样
 *        的锁就叫做可重入锁。在一个synchronized修饰的方法或代码块的内部，调用本类的其他
 *        synchronized修饰的方法或代码块时，是永远可以得到锁的。
 *验证可重入锁
 */
public class ReEnterLockDemo1 {
    static Object lockObject = new Object();
    public static void m1(){
        new Thread(() ->{
            synchronized (lockObject){
                System.out.println(Thread.currentThread().getName()+"\t"+"--------外层方法调用");
                synchronized (lockObject){
                    System.out.println(Thread.currentThread().getName()+"\t"+"--------中层方法调用");
                    synchronized (lockObject){
                        System.out.println(Thread.currentThread().getName()+"\t"+"--------里层方法调用");
                    }
                }
            }
        },"t1").start();
    }
    public static void main(String[] args) {
        m1();
    }
}
