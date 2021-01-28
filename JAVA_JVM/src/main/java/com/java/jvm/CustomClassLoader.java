package com.java.jvm;

public class CustomClassLoader extends ClassLoader {
    public static void main(String[] args) throws Exception {

        ClassLoader classLoader =  Class.forName("java.lang.String").getClassLoader();
        System.out.println(classLoader);

        //获取当前线程的上下文ClassLoader
        ClassLoader classLoader1 = Thread.currentThread().getContextClassLoader();
        System.out.println(classLoader1);

        ClassLoader classLoader2 = ClassLoader.getSystemClassLoader().getParent();
        System.out.println(classLoader2);
    }
}

