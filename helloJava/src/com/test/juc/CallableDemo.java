package com.test.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


/**
 * 面试题：callable接口与runnable接口的区别？
 *      答：1.Callable接口有返回值，Runnable接口没有返回值；
 *         2.Callable接口会抛出异常，Runnable接口不会抛出异常；
 *         3.落地方法不一样，一个是run，一个是call。
 */


class myThread implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        System.out.println("come in here");
        return 1024;
    }
}

public class CallableDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FutureTask futureTask = new FutureTask(new myThread());
        new Thread(futureTask,"A").start();
        System.out.println(futureTask.get());
    }
}
