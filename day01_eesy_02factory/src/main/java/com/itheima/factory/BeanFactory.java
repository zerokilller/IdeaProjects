package com.itheima.factory;


import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 一个创建Bean对象的工厂
 * Bean:在计算机英语中，有可重用组件的含义
 * JavaBean:用Java语言编写的可重用组件。JavaBean  >   实体类
 *          他就是创建我们的service和dao对象的。
 *第一个：需要一个配置文件来配置我们的service和dao
 *       配置的内容：唯一标识 = 全限定类名(key = value)
 *第二个：通过读取配置文件中配置的内容，反射创建对象
 *       我的配置文件可以是xml也可以是properties
 */
public class BeanFactory {
    //定义一个Properties对象
    private static Properties properties;
    //定义一个Map,用于存放我们要创建的对象。我们称之为容器
    private static Map<String,Object> beans;
    //使用静态代码块为properties对象赋值
    static {
        try{
            //实例化properties对象
            properties = new Properties();
            //获取properties文件的流对象
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            properties.load(in);
            //实例化容器
            beans = new HashMap<String,Object>();
            //取出配置文件中所有的key
            Enumeration keys = properties.keys();
            //遍历枚举
            while (keys.hasMoreElements()){
                //取出每个key
                String key = keys.nextElement().toString();
                //根据key获取value
                String beanPath = properties.getProperty(key);
                //反射创建对象
                Object value = Class.forName(beanPath).newInstance();
                //把key和value存入容器中
                beans.put(key,value);
            }
        }catch(Exception e){
            throw new ExceptionInInitializerError("初始化bean.properties失败 ");
        }
    }
    /**
     *@Description:
     *@Author:景文博
     *@Param:
     *@Return:
     */
    public static Object getBean(String name){
        return beans.get(name);
    }

   /* public static Object getBean(String beanName){
         Object bean = null;
         try{
             String beanpath = properties.getProperty(beanName);
             System.out.println(beanpath);
             bean = Class.forName(beanpath).newInstance();
         }catch(Exception e){
             e.printStackTrace();
         }
         return  bean;
    }*/
}
