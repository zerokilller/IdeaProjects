package com.itheima.jdbcTemplate;

import com.mchange.v2.c3p0.DriverManagerDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateDemo {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jt = ac.getBean(JdbcTemplate.class);
        //2.执行操作
        jt.execute("insert into account(name,money)values('ccc',1000)");
    }
}
