package com.test.juc;

import java.util.concurrent.TimeUnit;

/**
 * wait/sleep的区别？
 * 功能都是暂停当前线程，wait放开手去睡，放开手里的锁，sleep握紧手去睡，醒了手里还有锁。
 * Java线程的状态？
 * NEW,RUNNABLE,BLOCKED,WAITING,TIME_WAITING,TERMINATED.
 * start()方法调用之后是否线程是否立即启动？
 * start()方法调用之后只是将线程的状态改为就绪态，何时调用该线程取决于操作系统和CPU的底层调度。
 * 当一个接口中只有一个抽象方法的时候，这个接口就被称为函数式接口。
 * 函数式接口的标准定义方式：
 * @FunctionalInterface
 * Interface Foo{
 *     public void add();
 * }
 * lambda express 口诀：拷贝小括号，写死右箭头，落地大括号。
 * 函数式接口的定义需要使用@FunctionalInterface注解。
 * Java8以后，接口里面的方法允许有实现(default)，这个方法不算在那个抽象方法，所以与@FunctionalInterface
 * 不冲突，并且一个接口里面可以有多个default实现，而且接口里面还允许有多个静态方法的实现。
 * 高内聚低耦合前提下，实现线程操作资源类。(判断，干活，通知)
 * 注意标志位的修改和定位。
 * 多线程的交互中，必须要防止多线程的虚假唤醒。(也即，判断只能用while，不能用if)
 * 一个对象里面如果有多个synchronized方法，某一时刻内，只要有一个线程去调用其中的一个synchronized
 * 方法了，其他的线程都只能等待，换句话说，某一时刻内，只能有唯一的一个线程去访问这些synchronized方法
 * ，锁的是当前对象this，被锁定后，其他的线程都不能进入到当前对象的其他synchronized方法。
 * 加个普通方法后发现和同步锁无关。
 * 换成两个对象后，不是同一把锁，情况立刻变化。
 * 都换成静态同步方法后，情况立刻变化
 * new ，this, 具体的一个对象；
 * 静态 ，class，唯一的一个模版；
 * 所有的非静态同步方法用的都是同一把锁----实例对象本身。
 * synchronizeds实现同步的基础:Java中的每一个对象都可以作为锁，具体表现为一下三种形式：
 * 对于普通同步方法，锁的是当前实例对象。
 * 对于静态同步方法，锁的是当前类的Class对象。
 * 对于同步方法块，锁的是synchronized括号里面配置的对象。
 *
 * 当一个线程试图访问同步代码块时，他首先必须得到锁，退出或抛出异常时必须释放锁。
 * 也就是说如果一个实例对象的非静态同步方法获取锁后，该实例对象的其他非静态同步方法
 * 必须等待获取锁的方法释放锁后才能获取锁，可是别的实例对象的非静态同步方法因为跟
 * 该实例对象的非静态同步方法用的是不同的锁，所以不用等待该实例对象已获取锁的非静态
 * 同步方法释放锁就可以获取他们自己的锁。
 *
 * 所有的静态同步方法用的也是同一把锁-------类对象本身。
 * 这两把锁(this/Class)是两个不同的对象，所以静态同步方法与非静态同步方法之间是不会有竞态条件的。
 * 但是一旦一个静态同步方法获取锁后，其他的静态同步方法都必须等待该方法释放锁后才能获取锁。
 * 而不管是同一个实例对象的静态同步方法之间，还是不同的实例对象的静态同步方法之间，只要他们
 * 同一个类的实例对象：
 */


class Phone{
    public synchronized void sendEmail() throws Exception{
        //暂停一会线程
        try{ TimeUnit.SECONDS.sleep(4);}catch(InterruptedException e){e.printStackTrace();}
        System.out.println("---------------sendEmail");
    }
    public synchronized void sendMsg() throws Exception{
        System.out.println("---------------sendMsg");
    }
    public void sayHello() throws Exception{
        System.out.println("================sayHello");
    }
}
public class Lock8 {
    public static void main(String[] args) {
        Phone phone = new Phone();
        Phone phone1 = new Phone();
        new Thread(() ->{
           try{
               phone.sendEmail();
           }catch(Exception e) {
               e.printStackTrace();
           }
        },"A").start();

        new Thread(() ->{
            try{
              //  phone.sendMsg();
              //  phone.sayHello();
                phone1.sendMsg();
            }catch(Exception e) {
                e.printStackTrace();
            }
        },"B").start();
    }
}
