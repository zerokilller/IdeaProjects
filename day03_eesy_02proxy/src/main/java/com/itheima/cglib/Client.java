package com.itheima.cglib;

import com.itheima.proxy.IProducer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 模拟一个消费者
 */
public class Client {
    public static void main(String[] args) {
        final Producer producer = new Producer();
        /**
         *动态代理:
         *    特点:字节码随用随创建,随用随加载。
         *    作用:不修改源码的基础上对方法增强。
         *    分类:
         *              基于接口的动态代理
         *              基于子类的动态代理
         *   基于子类的动态代理:
         *       涉及的类:Enhancer
         *       提供者:第三方cglib库
         *   如何创建代理对象:
         *       使用Enhancer类中的create方法。
         *   创建代理对象的要求:
         *       被代理类不能是最终类
         *   create方法的参数:
         *        Class:字节码
         *            他是用于指定被代理对象的字节码。
         *        callback:用于提供增强的代码
         *              他是让我们写如何代理。我们一般都是写一个该接口的实现类，通常情况下都是
         *              匿名内部类，但不是必须的。此接口的实现类都是谁用谁写。
         *              我们一般写的都是该接口的子接口实现类:MethodInterceptor
         */

    }
}

















