package com.java.jvm;

public class jvm {
    public static void main(String[] args) {
        Thread t1 = new Thread();
        t1.start();
        //如何查看自己的电脑核数
        System.out.println(Runtime.getRuntime().availableProcessors());
        //返回Java虚拟机试图使用的最大内存量
        long maxMemory = Runtime.getRuntime().maxMemory();
        //返回Java虚拟机中的内存总量
        long totalMemory = Runtime.getRuntime().totalMemory();
        System.out.println("-Xmx:MAX_MEMORY = " +maxMemory+"(字节)"+
                (maxMemory/(double)1024/1024)+"MB");
        System.out.println("-Xms:TOTAL_MEMORY = " +totalMemory+"(字节)"+
                (totalMemory/(double)1024/1024)+"MB");
    }
}
