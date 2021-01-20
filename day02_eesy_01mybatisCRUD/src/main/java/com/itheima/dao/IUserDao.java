package com.itheima.dao;

import com.itheima.domain.QueryVo;
import com.itheima.domain.User;

import javax.management.Query;
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
     * 保存用户信息
     */
    void saveUser(User user);

    /**
     * 更新用户信息
     */
    void updateUser(User user);

    /**
     * 删除用户信息
     */
    void deleteUser(Integer userId);

    /**
     * 根据用户ID查询用户信息
     */
    User findById(Integer userId);

    /**
     * 根据用户姓名模糊查询用户信息
     */
    List<User> findByName(String name);

    /**
     * 查询总用户数
     */
    int findTotall();

    /**
     * 根据QueryVo中的条件查询用户
     */
    List<User> findUserByVo( QueryVo vo);

}
