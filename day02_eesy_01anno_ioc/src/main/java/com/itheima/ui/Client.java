 package com.itheima.ui;


import com.itheima.dao.IAccountDao;
import com.itheima.service.IAccountService;
import com.itheima.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

 /**
 * 模拟一个表现层，用于调用业务层
 */
public class  Client {
    /**
     *@Description:获取spring的ioc核心容器，并根据ID获取对象
     * ApplicationContext的三个常用实现类:
     *     ClassPathXmlApplicationContext:他可以加载类路径下的配置文件，要求配置文件必须在类路径下，不在的话，加载不了。
     *     FileSystemXmlApplicationContext:他可以加载磁盘任意路径下的配置文件(必须有访问权限)
     *     AnnotationConfigApplicationContext:他是用于读取注解创建容器的。
     *    核心容器的两个接口引发出的问题：
     *          ApplicationContext: 他在构建核心容器时，创建对象采取的策略是采用立即加载的方式。也就是说，只要一读取
     *                              配置文件马上就创建配置文件中配置的对象。(单例对象适用)
     *          BeanFactory:他在构建核心容器时，创建对象采取的策略是采用延迟加载的方式。也就是说，什么时候根据ID获取
     *                      对象了，什么时候才真正的创建对象。 (多例对象适用)
     *
     *@Author:景文博
     *@Param:
     *@Return:
     */
    public static void main(String[] args) {
        //1.获取核心容器对象
       // ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据ID获取bean对象
        IAccountService as = (IAccountService)ac.getBean("accountService");
       // IAccountService as1 = (IAccountService)ac.getBean("accountService");
        as.saveAccount();
        //System.out.println(as == as1);
        //IAccountDao accountDao = ac.getBean("accountDao",IAccountDao.class);
        //accountDao.saveAccount();
        //System.out.println(accountDao);
        ac.close();
    }
}
