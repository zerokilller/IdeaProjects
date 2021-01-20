package com.test.juc;


import java.util.concurrent.*;

/**
 * HashMap底层扩容会扩容为原来的2倍，ArrayList扩容会扩容为原来的1.5倍。
 *
 */

public class MyThreadPoolDemo {
    public static void main(String[] args) {
        //如何查看自己的电脑核数
        System.out.println(Runtime.getRuntime().availableProcessors());

        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                //这个数字其实跟你的电脑有关，如果是CPU密集型，直接是你的CPU核数加1或2
                //如果你的电脑是IO密集型这个数字为你的CPU的核数除以你的阻塞系数
                5,
                2L,
                 TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                 Executors.defaultThreadFactory(),
                 //默认的拒绝策略，直接爆出异常
                  new ThreadPoolExecutor.AbortPolicy());
                 //回退给调用线程:new ThreadPoolExecutor.CallerRunsPolicy() );
                 //直接抛弃多余的任务并且不会抛出异常(适用于弱一致性): new ThreadPoolExecutor.DiscardPolicy());
                 //抛弃队列中等待最久的任务new ThreadPoolExecutor.DiscardOldestPolicy());
        try{
            for (int i = 0; i <66; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                });
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }

    public static void initPool(String[] args) {
        //一池五个受理线程，类似一个银行有五个受理窗口，适用于执行长期任务性能好，
        //创建一个线程池，一池有N个固定的线程，有固定线程数的线程池。
        ExecutorService threadPool1 = Executors.newFixedThreadPool(5);
        //一池1个受理线程，类似一个银行有1个受理窗口
        ExecutorService threadPool2 = Executors.newSingleThreadExecutor();
        //执行很多短期异步任务，线程池根据需要创建新线程，但在先前构建的线程可用时将重用他们。
        //可扩容，遇强则强。一池N个工作线程，类似一个银行有N个受理窗口
        ExecutorService  threadPool = Executors.newCachedThreadPool();
        try{
            for (int i = 0; i <10; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                });
                try{
                    TimeUnit.SECONDS.sleep(4);}catch(InterruptedException e){e.printStackTrace();}
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
                threadPool.shutdown();
        }
    }
}
