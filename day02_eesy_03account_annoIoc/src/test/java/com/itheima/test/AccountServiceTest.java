package com.itheima.test;

import com.itheima.domain.Account;
import com.itheima.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {

    @Autowired
    private AccountServiceImpl accountService = null;
    @Test
    public void testFindAll(){
      //3.执行方法
        List<Account> accounts =  accountService.findAllAccount();
        //4.遍历结果集
        for(Account account:accounts){
            System.out.println(account);
        }
    }
    @Test
    public void testFindOne(){
        //3.执行方法
        Account account = accountService.findById(1);
        //4.打印结果
        System.out.println(account);
    }
    @Test
    public void testSave(){
        Account account = new Account();
        account.setMoney(100000000000.0);
        account.setName("景文博");
         //3.执行方法
        accountService.saveAccount(account);
    }
    @Test
    public void testUpdate(){
          //3.执行方法
        Account account = accountService.findById(1);
        account.setMoney(10000000000.0);
        accountService.updateAccount(account);
    }
    @Test
    public void testDeleteOne(){
        //3.执行方法
        accountService.deleteAccount(2);
    }
}
