package com.itheima.dao;

import com.itheima.domain.Account;
import com.itheima.domain.AccountUser;
import com.itheima.domain.User;

import java.nio.channels.AcceptPendingException;
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
      *@Description: 查询所有账户，并且带有用户名称和地址信息
      *@Author:景文博
      *@Param:
      *@Return:
      */
     List<AccountUser> findAllAccount();

     /**
      *@Description: 查询所有用户下的账户信息
      *@Author:景文博
      *@Param:
      *@Return:
      */
     List<User> findAllUser();
     

}
