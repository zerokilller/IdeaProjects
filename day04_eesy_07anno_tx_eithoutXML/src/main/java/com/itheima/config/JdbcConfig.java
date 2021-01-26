package com.itheima.config;


import com.mchange.v2.c3p0.DriverManagerDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 *和连接数据库相关的配置类
 */
public class JdbcConfig {

    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;
    /**
     *@Description: 创建JdbcTemplate对象
     *@Author: 景文博
     *@Param:
     *@return:
     */
    @Bean(name = "jdbcTemplate")
    public JdbcTemplate createjdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    /**
     *@Description: 创建数据源对象
     *@Author: 景文博
     *@Param:
     *@return:
     */
    @Bean(name = "dataSource")
    public DataSource createDataSource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
       ds.setDriverClass(driver);
       ds.setJdbcUrl(url);
       ds.setUser(username);
       ds.setPassword(password);
       return ds;
    }

}
