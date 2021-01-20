package com.test.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *    多个线程同时读一个资源类没有任何问题，所以为了满足并发量，读取共享资源应该可以同时进行
 * ，但是，如果有一个线程想去写共享资源，就不应该再有其他线程可以对该资源进行读或写。
 * 小总结：
 *          读-读能共存
 *          读-写不能共存
 *          写-写不能共存
 */

class Cache{
    private volatile Map map = new HashMap<>();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    public void put(String key,Object value){
        readWriteLock.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+" \t 写入数据"+key);
            //模拟网络延迟
            try{ TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e){e.printStackTrace();}
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+" \t 写入成功");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            readWriteLock.writeLock().unlock();
        }
    }
    public void get(String key){
        readWriteLock.readLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+" \t 读取数据");
            //模拟网络延迟
            try{ TimeUnit.SECONDS.sleep(1);}catch(InterruptedException e){e.printStackTrace();}
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName()+" \t 读取成功"+result);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            readWriteLock.readLock().unlock();
        }
    }
}
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        Cache cache = new Cache();
        for(int i = 0; i < 5; i++) {
            final int tempInt = i;
            new Thread(() -> {
                cache.put(tempInt+"",tempInt+"");
            }, String.valueOf(i)).start();
        }
        for(int i = 0; i < 5; i++) {
            final int tempInt = i;
            new Thread(() -> {
                cache.get(tempInt+"");
            }, String.valueOf(i)).start();
        }
    }
}
