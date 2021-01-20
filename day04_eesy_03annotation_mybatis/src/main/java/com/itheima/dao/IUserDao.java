package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IUserDao {
    /**
     *@Description:查询所有用户
     *@Author:景文博
     *@Param:
     *@Return:
     * 在mybatis中针对crud一共有四个注解:
     * @Select @Insert @Update @Delete
     */
    @Select("select * from user")
    List<User> findAll();
    
    /**
     *@Description:新增一个用户
     *@Author:景文博
     *@Param:
     *@Return:
     */
    @Insert("insert into user(username,address, sex,birthday)values(#{username},#{address},#{sex},#{birthday })")
    void saveUser(User user);

    /**
     *@Description:更新用户信息
     *@Author:景文博
     *@Param:
     *@Return:
     */
    @Update("update user set username = #{username},sex = #{sex},birthday = #{birthday},address = #{address} where id = #{id}")
    void updateUser(User user);

    /**
     *@Description:根据ID删除一个用户
     *@Author:景文博
     *@Param:
     *@Return:
     */
    @Delete("delete from user where id = #{id}")
    void deleteUser(Integer id);

    /**
     *@Description:根据ID查询用户信息
     *@Author:景文博
     *@Param:
     *@Return:
     */
    @Select("select * from user where id = #{id}")
    User findUserById(Integer id);

    /**
     *@Description:根据用户名称进行模糊查询
     *@Author:景文博
     *@Param:
     *@Return:
     */
  //  @Select("select * from user where username like #{username}")
    @Select("select * from user where username like '%${value}%'")
    List<User> findUserByUsername(String username);

    /**
     *@Description:查询总记录条数
     *@Author:景文博
     *@Param:
     *@Return:
     */
    @Select("select count(*) from user")
    int findTotal();
}
