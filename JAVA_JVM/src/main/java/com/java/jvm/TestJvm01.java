package com.java.jvm;

public class TestJvm01 {
    public static void main(String[] args) {

        //获取系统类加载器
        ClassLoader SystemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(SystemClassLoader); //jdk.internal.loader.ClassLoaders$AppClassLoader@73d16e93


        //获取其上层：扩展类加载器
        ClassLoader extClassLoader = SystemClassLoader.getParent();
        System.out.println(extClassLoader); //jdk.internal.loader.ClassLoaders$PlatformClassLoader@f6f4d33

        //获取其上层：获取不到启动类加载器
        ClassLoader boostrapClassLoader = extClassLoader.getParent();
        System.out.println(boostrapClassLoader); //null

        //对于用户自定义的类来说：默认使用系统类加载器进行加载
        ClassLoader classLoader = TestJvm01.class.getClassLoader();
        System.out.println(classLoader); //  jdk.internal.loader.ClassLoaders$AppClassLoader@73d16e93

        //String类使用启动类加载器进行加载。====>Java核心类库都是使用启动类加载器进行加载
        ClassLoader stringClassLoader = String.class.getClassLoader();
        System.out.println(stringClassLoader);   //null


    }
}
