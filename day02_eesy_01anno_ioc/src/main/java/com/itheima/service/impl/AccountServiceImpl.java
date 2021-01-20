package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.dao.impl.AccountDaoImpl;
import com.itheima.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 *账户的业务层实现类
 * 曾经的xml配置：
 *<bean id="accountService" class="com.itheima.service.impl.AccountServiceImpl"
 * scope="" init-method=""destroy-method="">
 * <property name="" value=""｜ref=""></property>
 * </bean>
 *用于创建对象的:他们的作用就和xml配置文件中编写一个<bean>标签实现的功能是一样的
 * @Component: 用于把当前类对象存入Spring容器中。
 *        属性: value:用于指定bean的id。当我们不写时，他的默认值是当前类名，且首字母改小写。
 * @Controller: 一般用在表现层
 * @Service: 一般用在业务层
 * @Repository: 一般用在持久层
 * 以上三个注解他们的作用和属性与Component是一模一样的。
 * 他们三个是Spring框架为我们提供明确的三层使用的注解，使我们的三层对象更加清晰。
 *用于注入数据的:他们的作用就和在xml配置文件中的bean标签中写一个<property>标签的作用是一样的。
 *              @Autowired :自动按照类型注入，只要容器中有唯一的一个bean对象类型和要注入的变量类型匹配，就可以注入成功。
 *                        如果Ioc容器中没有任何bean的类型和要注入的变量的类型匹配，则报错。
 *                        如果Ioc容器中有多个类型匹配时，Spring容器会根据bean对象的名称进行匹配，如果根据bean的名
 *                        称可以匹配上，则程序正确运行，否则报错。
 *              @Qualifier :在按照类型注入的基础之上在按照名称注入。他再给类成员注入时不能单独使用。但是在给方法参数注入时可以。
 *                          在给类成员注入时，需要和@Autowired搭配使用。
 *                          属性：value(用于指定注入bean的id)。
 *              @Resource :直接按照bean的id进行注入。他可以单独使用。
 *                         属性:(name)用于指定bean的id。
 *                         出现位置:可以是变量上，也可以是方法上。
 *                         以上三个注入都只能注入其他bean类型的数据，而基本类型和String类型无法使用上述注解实现。
 *                         另外，集合类型的注入只能通过xml来实现。
 *                         细节:在使用注解注入时，set方法就不是必须的了。
 *              @Value : 用于注入基本类型数据和String数据类型的数据。
 *                       属性:(value)用于指定数据的值，他可以使用Spring中的SpEL(也就是Spring的el表达式)。
 *                            SpEL的写法:${表达式}。
 *用于改变作用范围的:他们的作用就和在bean标签中使用scope属性实现的功能是一样的。
 *             @Scope : 用于指定bean的作用范围。
 *                      属性:(value)用于指定范围的取值，常用取值：singleton prototype。
 *和生命周期相关:他们的作用就和在bean标签中使用init-method和destroy-method的作用是一样的。(了解)
 *             @PreDestory :用于指定销毁方法。
 *             @PostConstruct :用于初始化方法。
 *
 */
@Repository(  "accountService")
@Scope("singleton")   //多例对象的销毁Spring不负责，由JavaGC负责。Spring默认为单例对象。
public class AccountServiceImpl implements IAccountService {
    @Autowired
    @Qualifier("accountDao")
    private IAccountDao accountDao = null;

    @PostConstruct
    public void init(){
        System.out.println("初始化方法开始执行了");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("销毁方法开始执行了");
    }

    @Override
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
