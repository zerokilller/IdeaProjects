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
     * 根据用户ID查询用户信息
     */
    User findById(Integer userId);

    /**
     * 根据用户姓名模糊查询用户信息
     */
    List<User> findByName(String name);

    /**
     * 根据QueryVo中的条件查询用户
     */
    List<User> findUserByVo( QueryVo vo);

    /**
     *@Description:通过传入条件进行查询
     *@Author:景文博
     *@Param: User
     *@Return: List<User>
     */
    List<User> findUserByCondition(User user);

    /**
     *@Description:通过ID集合查询
     *@Author:景文博
     *@Param:ids
     *@Return: List<User>
     */
    List<User> findUserInIds(QueryVo queryVo);


}
