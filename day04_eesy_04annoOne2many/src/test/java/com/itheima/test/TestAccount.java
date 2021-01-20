package com.itheima.test;

import com.itheima.dao.IAccountDao;
import com.itheima.dao.IUserDao;
import com.itheima.domain.Account;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class TestAccount {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession sqlSession;
    private IAccountDao accountDao;

    @Before
    public void init() throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = factory.openSession();
        accountDao = sqlSession.getMapper(IAccountDao.class);
    }

    @After
    public void destory() throws Exception{
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

    /**
     *@Description:测试根据用户ID查询用户信息
     *@Author:景文博
     *@Param:
     *@Return:
     */
    @Test
    public void testFindAll(){
        List<Account> accounts = accountDao.findAll();
        for(Account account:accounts) {
            System.out.println(account);
            System.out.println(account.getUser() );
        }
    }
}
