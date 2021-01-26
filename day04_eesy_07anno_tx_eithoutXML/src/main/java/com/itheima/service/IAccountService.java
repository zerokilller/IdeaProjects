package com.itheima.service;

import com.itheima.domain.Account;
import org.springframework.stereotype.Service;

/**
 *账户的业务层接口
 */
public interface IAccountService {

        /**
         *@Description: 根据ID查询账户信息
         *@Author: 景文博
         *@Param:
         *@return:
         */
        Account findAccountById(Integer accountId);
        
        /**
         *@Description: 转账业务
         *@Author: 景文博
         *@Param: 
         *@return:
         */
        void transfer(String sourceName,String targetName,float money);
        
}
