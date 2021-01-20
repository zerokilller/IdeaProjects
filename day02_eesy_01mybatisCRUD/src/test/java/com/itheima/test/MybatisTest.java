package com.itheima.test;

import com.itheima.dao.IUserDao;
import com.itheima.domain.QueryVo;
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

/**
*@ClassName: MybatisTest
*@Description:测试mybatis的crud操作
*@Author:景文博
*/
public class MybatisTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao userDao;

    @Before //用于在测试方法之前执行
    public void init() throws Exception{
        //1.读取配置文件，生成字节输入流
         in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFacory对象
        SqlSessionFactory facory = new SqlSessionFactoryBuilder().build(in);
        //3.获取SqlSession对象
        sqlSession = facory.openSession(true);
        //4.获取dao的代理对象
        userDao = sqlSession.getMapper(IUserDao.class);
    }

    @After //用户在测试方法之后执行
    public void destory() throws Exception{
        //提交事物
       // sqlSession.commit();
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
        }
    }

    /**
     * 测试保存用户操作
     */
    @Test
    public void testSave(){
        User user = new User();
        user.setUsername("小景");
        user.setAddress("西安");
        user.setSex("男");
        user.setBirthday(new Date());
        System.out.println("保存操作之前:"+user);
        //5.执行保存用户操作
        userDao.saveUser(user);
        System.out.println("保存操作之后:"+user);
    }

    /**
     * 测试更新用户操作
     */
    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(48);
        user.setUsername("二蛋");
        user.setAddress("伊拉克");
        user.setSex("女");
        user.setBirthday(new Date());

        //5.执行更新用户操作
        userDao.updateUser(user);
    }

    /**
     * 测试删除用户操作
     */
    @Test
    public void testDelete(){

        //5.执行删除用户操作
        userDao.deleteUser(48);
    }

    /**
     * 测试根据用户ID查询用户信息操作
     */
    @Test
    public void testFindById(){
        User user = userDao.findById(47);
        System.out.println(user);
    }

    /**
     * 测试根据用户姓名模糊查询用户信息操作
     */
    @Test
    public void testFindByName(){
      //  List<User> users = userDao.findByName("%王%");
        List<User> users = userDao.findByName("王");
        for(User user:users){
            System.out.println(user);
        }
    }

    /**
     * 测试查询总记录条数操作
     */
    @Test
    public void testFindTotall(){
        //5.执行删除用户操作
        int totall = userDao.findTotall();
        System.out.println(totall);
    }

    /**
     * 测试根据queryVo模糊查询用户信息操作
     */
    @Test
    public void testFindByVo(){
        //  List<User> users = userDao.findByName("%王%");
        QueryVo queryVo = new QueryVo();
        User user = new User();
        user.setUsername("%王%");
        queryVo.setUser(user);
        List<User> users = userDao.findUserByVo(queryVo);
        for(User u:users){
            System.out.println(u);
        }
    }

    @Test
    public void testObject(){
        Object object = new Object();
        System.out.println(object.getClass().getClassLoader());
    }

}
