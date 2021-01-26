package com.itheima.dao;

import com.itheima.domain.Account;

/**
 *账户的dao层接口
 */
public interface IAccountDao {
    /**
     *根据ID查询账户
     */
    Account findById(Integer accountId);

    /**
     *根据name查询账户
     */
    Account findByName(String accountName);

    /**
     *更新账户
     */
    void updateAccount(Account account);
}
