package com.itheima.test;

import com.itheima.dao.IAccountDao;
import com.itheima.dao.IUserDao;
import com.itheima.domain.Account;
import com.itheima.domain.AccountUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class AccountTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IAccountDao accountDao;

    @Before //用于在测试方法之前执行
    public void init() throws Exception{
        //1.读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFacory对象
        SqlSessionFactory facory = new SqlSessionFactoryBuilder().build(in);
        //3.获取SqlSession对象
        sqlSession = facory.openSession();
        //4.获取dao的代理对象
        accountDao = sqlSession.getMapper(IAccountDao.class);
    }

    @After //用户在测试方法之后执行
    public void destory() throws Exception{
        //提交事物
        sqlSession.commit();
        //6.释放资源
        sqlSession.close();
        in.close();
    }

    /**
     *@Description:查询所有账户
     *@Author:景文博
     *@Param:
     *@Return:
     */
    @Test
    public void testFindAll(){
        List<Account> accounts = accountDao.findAll();
        for(Account account: accounts){
            System.out.println("----------------每个account的信息-----------------");
            System.out.println(account);
        }
    }

    /**
     *@Description:查询所有账户,并且带有用户名称和地址信息
     *@Author:景文博
     *@Param:
     *@Return:
     */
    @Test
    public void testFindAllAccount(){
        List<AccountUser> accounts = accountDao.findAllAccount();
        for(AccountUser account: accounts){
            System.out.println(account);
        }
    }

}
