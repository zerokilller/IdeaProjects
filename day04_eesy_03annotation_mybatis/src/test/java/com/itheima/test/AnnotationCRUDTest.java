package com.itheima.test;

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
import java.util.Date;
import java.util.List;

public class AnnotationCRUDTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Before
    public void init() throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = factory.openSession();
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After
    public void destory() throws Exception{
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

    /**
     *@Description:测试保存用户
     *@Author:景文博
     *@Param:
     *@Return:
     */

    @Test
    public void testSave(){
        User user = new User();
        user.setUsername("小花");
        user.setAddress("西安");
        user.setSex("女");
        user.setBirthday(new Date());

        userDao.saveUser(user);
    }

    /**
     *@Description:测试更新用户
     *@Author:景文博
     *@Param:
     *@Return:
     */
    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(41);
        user.setUsername("小花");
        user.setAddress("西安");
        user.setSex("女");
        user.setBirthday(new Date());

        userDao.updateUser(user);
    }

    /**
     *@Description:测试删除一个用户
     *@Author:景文博
     *@Param:
     *@Return:
     */
    @Test
    public void testDeleteUser(){
        userDao.deleteUser(21);
    }

    /**
     *@Description:测试根据用户ID查询用户信息
     *@Author:景文博
     *@Param:
     *@Return:
     */
    @Test
    public void testFindUserById(){
        User user = userDao.findUserById(52);
        System.out.println(user);
    }

    /**
     *@Description:测试根据用户名称进行模糊查询
     *@Author:景文博
     *@Param:
     *@Return:
     */
    @Test
    public void testFindUserByUsername(){
     //   List<User> users = userDao.findUserByUsername("%王%");
        List<User> users = userDao.findUserByUsername("王");
        for(User user:users){
            System.out.println(user);
        }
    }

    /**
     *@Description:测试查询总记录条数
     *@Author:景文博
     *@Param:
     *@Return:
     */
    @Test
    public void testFindTotal(){
        int sum = userDao.findTotal();
        System.out.println(sum);
    }
}
