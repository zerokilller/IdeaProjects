package com.itheima.test;


import com.itheima.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *使用junit单元测试:测试我们的配置
 *使用注解实现aop转账的时候，如果不使用环绕通知的话，最终通知会先于后置通知执行，导致连接释放，
 *使得提交失效。而使用环绕通知的话，由于是我们自己手动控制业务方法的执行位置，所以不会出现这种
 *问题。
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {

    @Autowired
    private IAccountService as;

    @Test
    public void testTransfer(){
        as.transfer("aaa","ccc",100f);
    }

}
