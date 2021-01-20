package com.itheima.dao.impl;

import com.itheima.dao.IUserDao;
import com.itheima.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl  implements IUserDao {

    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }
    @Override
    public List<User> findAll() {
        //1.使用工厂生产SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //2.使用SqlSession执行查询所有操作
        //namespace和id定位到findAll方法
        List<User> users = sqlSession.selectList("com.itheima.dao.IUserDao.findAll");
        sqlSession.close();
        return users;
    }
}
