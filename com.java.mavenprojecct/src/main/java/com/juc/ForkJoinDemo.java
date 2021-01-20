package com.juc;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * 合并分支框架
 */
//RecursiveTask递归任务
class MyTask extends RecursiveTask<Integer>{
    private static final Integer ADJUST_VALUE = 10;
    private int begin;
    private int end;
    private int result;

    public MyTask(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if(end - begin <= ADJUST_VALUE){
            for (int i = begin; i <= end; i++) {
                result = result + i;
            }
        }else{
            int middle = (end + begin)/2;
            MyTask myTask01 = new MyTask(begin,middle);
            MyTask myTask02 = new MyTask(middle+1,end);
            //调用fork方法其实就是在调用compute()方法。
            myTask01.fork();
            myTask02.fork();
            result = myTask01.join() + myTask02.join();
        }
        return result;
    }
}
public class ForkJoinDemo {
    public static void main(String[] args) throws Exception {
        MyTask myTask = new MyTask(1,100);
        ForkJoinPool threadPool = new ForkJoinPool();
        ForkJoinTask<Integer> forkJoinTask = threadPool.submit(myTask);
        System.out.println(forkJoinTask.get());
        threadPool.shutdown();
    }
}

