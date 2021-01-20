package com.itheima.service;


/**
 *@Description: 账户的业务层接口
 *@Author: 景文博
 *@Param: 
 *@return:
 */
public interface IAccountService  {
    /**
     *@Description: 模拟保存账户
     *@Author: 景文博
     *@Param: 
     *@return:
     */
    void saveAccount();

    /**
     *@Description: 模拟更新账户
     *@Author: 景文博
     *@Param:
     *@return:
     */
    void updateAccount(Integer i );

    /**
     *@Description: 模拟删除账户
     *@Author: 景文博
     *@Param:
     *@return:
     */
    int deleteAccount();
}
