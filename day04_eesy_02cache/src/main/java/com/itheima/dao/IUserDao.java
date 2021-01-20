 package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

/**
 *用户的持久层接口
 */
public interface IUserDao {
    /**
     * 查询所有方法
     */
    List<User> findAll();

    /**
     * 根据用户ID查询用户信息
     */
    User findById(Integer userId);

    /**
     *@Description: 更新用户信息
     *@Author:景文博
     *@Param:
     *@Return:
     */
    void updateUser(User user);
}
