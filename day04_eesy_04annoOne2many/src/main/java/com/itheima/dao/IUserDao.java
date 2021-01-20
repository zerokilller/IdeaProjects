package com.itheima.dao;

import com.itheima.domain.Account;
import com.itheima.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

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
    @Results(id="userMap",value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "address",property = "address"),
            @Result(column = "birthday",property = "birthday"),
            @Result(property = "accounts",column = "id",
                    many = @Many(select = "com.itheima.dao.IAccountDao.findAccountByUid",
                            fetchType = FetchType.LAZY )),
    })
    List<User> findAll();

    /**
     *@Description:根据ID查询用户信息
     *@Author:景文博
     *@Param:
     *@Return:
     */
    @Select("select * from user where id = #{id}")
    User findById(Integer id);

    /**
     *@Description:根据用户名称进行模糊查询
     *@Author:景文博
     *@Param:
     *@Return:
     */
    @Select("select * from user where username like #{username}")
    List<User> findUserByUsername(String username);


}
