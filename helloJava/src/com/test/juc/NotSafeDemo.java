package com.test.juc;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 1.故障现象
 *   java.util.ConcurrentModificationException
 * 2.导致原因
 *
 * 3.解决方案
 *      3.1使用线程安全的Vector(效率低下，因为底层方法使用重锁synchronized);
 *      3.2使用工具类Collections.synchronizedList(new ArrayList<>())将线程不安全的
 *         ArrayList转化为线程安全的synchronizedList(适用于小数据量);
 *      3.3使用Java.Util.Concurrent工具类里的CopyOnWriteArrayList(写时复制);
 *          CopyOnWriter容器即写时复制容器。往一个容器添加元素的时候，不直接往当前容器object[]
 *        添加，而是先将当前容器object[]进行Copy，复制出一个新的容器object[] newElements,然后
 *        往新的容器object[] newElements里添加元素，添加完元素之后，再将原容器的引用指向新的容器
 *        setArray(newElements);这样做的好处是可以对CopyOnWrite容器进行并发的读，而不需要加锁，
 *        因为当前容器不会添加任何元素。所以CopyOnWrite容器也是一种读写分离的思想，读和写不同的容
 *        器。
 *         public boolean add(E e) {
 *         synchronized (lock) {
 *             Object[] es = getArray();
 *             int len = es.length;
 *             es = Arrays.copyOf(es, len + 1);
 *             es[len] = e;
 *             setArray(es);
 *             return true;
 *              }
 *          }
 *
 * 4.优化建议
 *
 * hashSet的底层数据结构是hashMap,hashSet的add方法调用的其实就是Map的put方法，
 * public boolean add(E e) {
 *         return map.put(e, PRESENT)==null;
 *     }
 *PRESENT为写死的一个对象:private static final Object PRESENT = new Object();
 * ArrayList底层是一个对象数组。
 *
 */

public class NotSafeDemo {

    public static void mapNotSafe(String[] args) {
        Map<String,String> map = new ConcurrentHashMap<>();
                                //new HashMap<>();
        for(int i = 0; i < 30; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,8));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }
    }
    public static void setNotSafe(String[] args) {
        Set<String> set = new CopyOnWriteArraySet<>();
                         // Collections.synchronizedSet(new HashSet<>());
                         //new HashSet<>();
        new HashSet<>();
        for(int i = 0; i < 30; i++) {
            new Thread(() -> {
            set.add(UUID.randomUUID().toString().substring(0,8));
            System.out.println(set);
            }, String.valueOf(i)).start();
        }
    }
    public static void listNotSafe(String[] args) {
        List<String> list =  new CopyOnWriteArrayList<>();
                            //Collections.synchronizedList(new ArrayList<>());
                            //new Vector<>();
                            // new ArrayList<>();
        for(int i = 0; i < 3 ; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}
