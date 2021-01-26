package com.itheima.jdbcTemplate;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountDao accountDao = ac.getBean("AccountDaoImpl",IAccountDao.class);
        Account account = accountDao.findById(1);
        System.out.println(account);
        account.setMoney(1000000f);
        accountDao.updateAcount(account) ;
    }
}
