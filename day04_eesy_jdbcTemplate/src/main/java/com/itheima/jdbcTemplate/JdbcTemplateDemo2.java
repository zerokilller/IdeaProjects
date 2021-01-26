package com.itheima.jdbcTemplate;

import com.itheima.dao.impl.AccountDaoImpl;
import com.itheima.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateDemo2 {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountDaoImpl accountDao = ac.getBean(AccountDaoImpl.class);
        //2.执行操作
        Account account = accountDao.findById(2);
        System.out.println(account);
        }
}
