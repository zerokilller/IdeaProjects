package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import com.itheima.service.IAccountService;

import java.util.List;

/**
 *@Description:账户的业务层实现类
 *@Author:景文博
 *@Param:
 *@Return:
 *
 * 事物控制都应该在业务层
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;


    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    @Override
    public Account findById(Integer id) {
            return accountDao.findById(id);
    }

    @Override
    public void saveAccount(Account account) {
            accountDao.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
            accountDao.updateAccount(account);
    }

    @Override
    public void deleteAccount(Integer id) {
            accountDao.deleteAccount(id);
    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        System.out.println("转账方法开始执行");
            //2.执行操作
            //2.1根据名称查询转出账户
            Account sourceAccount = accountDao.findByName(sourceName);
            //2.2根据名称查询转入账户
            Account targetAccount = accountDao.findByName(targetName);
            //2.3转出账户减钱
            sourceAccount.setMoney(sourceAccount.getMoney()-money);
            //2.4转入账户加钱
            int a = 9 / 0;
            targetAccount.setMoney(targetAccount.getMoney()+money);
            //2.5更新转出账户
            accountDao.updateAccount(sourceAccount);
            //2.6更新转入账户
            accountDao.updateAccount(targetAccount);
    }
}
