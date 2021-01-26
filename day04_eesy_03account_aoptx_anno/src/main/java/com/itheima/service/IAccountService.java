package com.itheima.service;

import com.itheima.domain.Account;

import java.util.List;

/**
 *@Description:账户的业务层接口
 *@Author:景文博
 *@Param:
 *@Return:
 */
public interface IAccountService {
    
    /**
     *@Description:查询所有
     *@Author:景文博
     *@Param:
     *@Return:
     */
    List<Account> findAllAccount();
    
    /**
     *@Description:根据ID查询账户信息
     *@Author:景文博
     *@Param:id
     *@Return:
     */
    Account findById(Integer id);  
    
    /**
     *@Description:保存用户
     *@Author:景文博
     *@Param:account
     *@Return:
     */
    void saveAccount(Account account);
    
    /**
     *@Description:更新一个账户信息 
     *@Author:景文博
     *@Param:account
     *@Return:
     */
    void updateAccount(Account account);
    
    /**
     *@Description:删除用户
     *@Author:景文博
     *@Param:id
     *@Return:
     */
    void deleteAccount(Integer id);
    
    /**
     *@Description:  转账
     *@Author: 景文博
     *@Param: sourceName    //转出账户名称
     *@Param: targetName    //转入庄户名称
     *@Param: money         //转账金额
     *@Return:
     */
    void transfer(String sourceName,String targetName,Float money);
    
}
