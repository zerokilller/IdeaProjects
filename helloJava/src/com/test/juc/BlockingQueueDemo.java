package com.test.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
/**
 *    通过String str = "abc",这种方式声明一个字符串，其实就是在方法区常量池中开辟了
 * 一块空间，将空间赋值为"abc",如果再次声明一个相同的字符串，其实就是将引用指向现有内容
 * 一样的字符串，如果没有才会在字符串常量池中重新开启一片空间将其赋值。
 *    当队列是空的，从队列中获取元素的操作将会被阻塞；
 *    当队列是满的，从队列中添加元素的操作将会被阻塞。
 *    试图从空的队列中获取元素的线程将会被阻塞，直到其他线程往空的队列插入新的元素。
 *    试图向已满的队列中添加新元素的线程将会被阻塞，直到其他线程从队列中移除一个或多个元素或者完全清空
 *    ，使队列变得空闲起来并后续新增。
 *    阻塞队列的用处：
 *          在多线程领域:所谓阻塞，在某些情况下会挂起线程(即阻塞)，一旦条件满足，被挂起的线程又会自动
 *    被唤醒。为什么需要BlockingQueue？好处是我们不需要关心什么时候需要阻塞线程，什么时候需要唤醒线程
 *    ，因为这一切BlockingQueue都给你一手包办了，在concurrent包发布前，在多线程环境下，我们程序员都
 *    必须去自己控制这些细节，尤其还要兼顾效率和线程安全，而这会给我们的程序带来不小的复杂度。
 *    ArrayBlockingQueue:由数组结构组成的有界阻塞队列。(重要)
 *    LinkedBlockingQueue:由链表组成的有界(但大小默认为Integer.MAX_VALUE)阻塞队列。(重要)
 *    PriorityBlockingQueue:支持优先级排序的无界阻塞队列。
 *    DelayQueue：使用优先级队列实现的延迟无界阻塞队列。
 *    SynchronousQueue:不存储元素的阻塞队列，也即单个元素的队列。(重要)
 *    LinkedTransferQueue:由链表组成的无界阻塞队列。
 *    LinkedBlockingDeque:由链表组成的双向阻塞队列。
 *
 */


public class BlockingQueueDemo {
    public static void Exception(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
        //Exception in thread "main" java.lang.IllegalStateException: Queue full
        System.out.println(blockingQueue.add("a"));

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        //Exception in thread "main" java.util.NoSuchElementException
        System.out.println(blockingQueue.remove());
        //blockingQueue.element()返回队列队首元素
        System.out.println(blockingQueue.element());
    }

    public static void offerAndPoll(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.offer("x"));

//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());
//        System.out.println(blockingQueue.poll());

        System.out.println(blockingQueue.peek());
    }

    public static void putAndTake(String[] args) throws Exception {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
      //  blockingQueue.put("a");
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
     //   System.out.println(blockingQueue.take());
    }

    public static void offerAndPollOuttime(String[] args) throws Exception {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.offer("q",3, TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll());
    }

}
