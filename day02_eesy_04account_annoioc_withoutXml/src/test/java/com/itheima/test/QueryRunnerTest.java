package com.itheima.test;


import config.SpringConfiguration;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *@Description:测试QueryRunner是否是单例
 *@Author:景文博
 *@Param:
 *@Return:
 */
public class QueryRunnerTest {
     @Test
    public void testQueryRunner(){
         //1.获取容器
         ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
         //2.获取测试QueryRunner对象
         QueryRunner queryRunner1 = ac.getBean("queryRunner", QueryRunner.class);
         QueryRunner queryRunner2 = ac.getBean("queryRunner", QueryRunner.class);
         System.out.println(queryRunner1 == queryRunner2);
     }
}
