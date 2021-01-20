package com.itheima.testAccount;

import com.itheima.service.IAccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAccount {
    private IAccountService as;
    @Before
    public void init(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        as = ac.getBean(IAccountService.class);
    }
    @Test
    public void testAccount(){
        as.saveAccount();
        as.updateAccount(1);
        as.deleteAccount();
    }
}
