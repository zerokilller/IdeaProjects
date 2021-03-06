package com.itheima.test;

import com.itheima.dao.IAccountDao;
import com.itheima.dao.IUserDao;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
*@ClassName: MybatisTest
*@Description:测试mybatis的crud操作
*@Author:景文博
*/
public class MybatisTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;
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
        userDao = sqlSession.getMapper(IUserDao.class);
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
     * 查询所有
     */
    @Test
    public void testFindAll() throws Exception{

        //5.执行查询所有方法
        List<User> users = userDao.findAll();
        for(User user: users){
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }

    /**
     * 测试根据用户ID查询用户信息操作
     */
    @Test
    public void testFindById(){
        User user = userDao.findById(47);
        System.out.println(user);
    }
}
