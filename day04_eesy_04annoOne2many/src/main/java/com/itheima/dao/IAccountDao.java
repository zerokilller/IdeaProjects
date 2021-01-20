package com.itheima.dao;

import com.itheima.domain.Account;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface IAccountDao {
    /**
     *@Description:查询所有账户，并且获取每个账户所属用户信息
     *@Author:景文博
     *@Param:
     *@Return:
     */
    @Select("select * from account")
    @Results(id="accountMap",value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "uid",property = "uid"),
            @Result(column = "money",property = "money"),
            @Result(property = "user",column = "uid",one = @One(select = "com.itheima.dao.IUserDao.findById",fetchType = FetchType.EAGER)),
    })
    List<Account> findAll();

    /**
     *@Description:根据用户ID查询账户信息
     *@Author:景文博
     *@Param:
     *@Return:
     */
    @Select("select * from account where uid = #{id}")
    List<Account> findAccountByUid(Integer uid);
    
}
