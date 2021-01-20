package com.itheima.test;

import com.itheima.domain.Account;
import com.itheima.service.impl.AccountServiceImpl;
import config.JdbcConfig;
import config.SpringConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 *@Description:使用Junit单元测试：测试我们的配置
 *@Author:景文博
 *@Param:
 *@Return:
 * Spring整合junit的配置:
 *      1.导入Spring整合junit的jar(坐标)
 *      2.使用Junit提供的一个注解把原有的main方法替换了，替换成Spring提供的@Runwith
 *      3.告知Spring的运行器，Spring和ioc创建是基于xml还是注解的，并且说明位置
 *              @ContextConfiguration
 *                  locations:指定xml文件的位置，加上classpath关键字，表示在类路径下。
 *                  classes:指定注解类所在的位置。
 *        当我们使用Spring5.x版本的时候，要求junit的jar必须是4.12及以上。
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {
    @Autowired
    private AccountServiceImpl as = null;
    @Test
    public void testFindAll(){
        //3.执行方法
        List<Account> accounts =  as.findAllAccount();
        //4.遍历结果集
        for(Account account:accounts){
            System.out.println(account);
        }
    }
    @Test
    public void testFindOne(){
       //3.执行方法
        Account account = as.findById(1);
        //4.打印结果
        System.out.println(account);
    }
    @Test
    public void testSave(){
        Account account = new Account();
        account.setMoney(100000000000.0);
        account.setName("翠花");
         //3.执行方法
        as.saveAccount(account);
    }
    @Test
    public void testUpdate(){
        //3.执行方法
        Account account = as.findById(1);
        account.setMoney(10000000000.0);
        as.updateAccount(account);
    }
    @Test
    public void testDeleteOne(){
           //3.执行方法
        as.deleteAccount(2);
    }
}
