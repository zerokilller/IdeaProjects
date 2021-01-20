package com.itheima.test;

import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import com.itheima.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AccountServiceTest {
    @Test
    public void testFindAll(){
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        AccountServiceImpl accountService = ac.getBean("accountService",AccountServiceImpl.class);
        //3.执行方法
        List<Account> accounts =  accountService.findAllAccount();
        //4.遍历结果集
        for(Account account:accounts){
            System.out.println(account);
        }
    }
    @Test
    public void testFindOne(){
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        AccountServiceImpl as = ac.getBean("accountService",AccountServiceImpl.class);
        //3.执行方法
        Account account = as.findById(1);
        //4.打印结果
        System.out.println(account);
    }
    @Test
    public void testSave(){
        Account account = new Account();
        account.setMoney(100000000000.0);
        account.setName("景文博");
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        AccountServiceImpl as = ac.getBean("accountService",AccountServiceImpl.class);
        //3.执行方法
        as.saveAccount(account);
    }
    @Test
    public void testUpdate(){
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        AccountServiceImpl as = ac.getBean("accountService",AccountServiceImpl.class);
        //3.执行方法
        Account account = as.findById(1);
        account.setMoney(10000000000.0);
        as.updateAccount(account);
    }
    @Test
    public void testDeleteOne(){
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        AccountServiceImpl as = ac.getBean("accountService",AccountServiceImpl.class);
        //3.执行方法
        as.deleteAccount(2);
    }
}
