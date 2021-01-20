package com.itheima.dao;

import com.itheima.domain.Account;
import com.itheima.domain.User;

import java.security.IdentityScope;
import java.util.List;

public interface IAccountDao {
     /**
      *@Description:查询所有账户,同时获取到用户下所有账户的信息
      *@Author:景文博
      *@Param:
      *@Return:
      */
     List<Account> findAll();
     
     /**
      *@Description:根据用户id查询账户信息 
      *@Author:景文博
      *@Param:
      *@Return:
      */
     List<Account> findAccountByUid(Integer uid);
     
}
