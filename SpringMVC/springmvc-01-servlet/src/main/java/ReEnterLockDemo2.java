

/**
 *可重入锁:可重复可递归调用的锁，在外层使用锁之后，在内层仍然可以使用，并且不发生死锁，这样
 *        的锁就叫做可重入锁。在一个synchronized修饰的方法或代码块的内部，调用本类的其他
 *        synchronized修饰的方法或代码块时，是永远可以得到锁的。
 *验证可重入锁
 */
public class ReEnterLockDemo2 {
    public synchronized void m1(){
        System.out.println(Thread.currentThread().getName()+"\t"+"--------外层方法调用");
        m2();
    }
    public static synchronized void m2(){
        System.out.println(Thread.currentThread().getName()+"\t"+"--------中层方法调用");
        m3();
    }
    public static synchronized void m3(){
        System.out.println(Thread.currentThread().getName()+"\t"+"--------里层方法调用");
    }
    public static void main(String[] args) {

        ReEnterLockDemo2 reEnterLockDemo = new ReEnterLockDemo2();
        reEnterLockDemo.m1();
    }
}
