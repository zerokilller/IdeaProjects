package com.itheima.service.impl;

import com.itheima.dao.impl.AccountDaoImpl;
import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("AccountServiceImpl")
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountDaoImpl accountDao;



    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao.findById(accountId);
    }

    @Override
    public void transfer(String sourceName, String targetName, float money) {
        System.out.println("转账方法开始执行");
        //根据名称查询转出账户
        Account sourceAccount = accountDao.findByName(sourceName);
        //根据名称查询转入账户
        Account targetAccount = accountDao.findByName(targetName);
        //转出账户减钱
        sourceAccount.setMoney(sourceAccount.getMoney() - money);
        //转入账户加钱
        targetAccount.setMoney(targetAccount.getMoney() + money);
         int a = 9 / 0;
        //更新转出账户
        accountDao.updateAccount(sourceAccount);
        //更新转入账户
        accountDao.updateAccount(targetAccount);
    }
}
