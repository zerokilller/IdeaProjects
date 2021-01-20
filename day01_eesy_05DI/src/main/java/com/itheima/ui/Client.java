 package com.itheima.ui;


 import com.itheima.service.IAccountService;
 import org.springframework.context.ApplicationContext;
 import org.springframework.context.support.ClassPathXmlApplicationContext;

 /**
 * 模拟一个表现层，用于调用业务层
 */
public class  Client {
    public static void main(String[] args) {
        //1.获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据ID获取bean对象
        //IAccountService as = (IAccountService)ac.getBean("accountService");
        //IAccountService as = (IAccountService)ac.getBean("accountService1");
        IAccountService as = (IAccountService)ac.getBean("accountService2");
        as.saveAccount();
    }
}
