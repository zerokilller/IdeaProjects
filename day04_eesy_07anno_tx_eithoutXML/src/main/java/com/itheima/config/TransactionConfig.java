package com.itheima.config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 *和事务相关的配置类
 */
public class TransactionConfig {
    /**
     *@Description: 用于创建事务管理器对象
     *@Author: 景文博
     *@Param:
     *@return:
     */
    @Bean(name = "platformTransactionManager")
    public PlatformTransactionManager createPlatformTransactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

}
