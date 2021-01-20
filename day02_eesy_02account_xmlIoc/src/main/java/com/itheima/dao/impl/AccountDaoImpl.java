package com.itheima.dao.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;


import java.util.List;

/**
 *@Description:账户的持久层实现类
 *@Author:景文博
 *@Param:
 *@Return:
 */
public class AccountDaoImpl implements IAccountDao {
    QueryRunner queryRunner;

    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }

    @Override
    public List<Account> findAllAccount() {
        try{
            return queryRunner.query("select * from account",new BeanListHandler<Account>(Account.class));
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account findById(Integer id) {
        try{
            return queryRunner.query("select * from account where id = ?",new BeanHandler<Account>(Account.class),id);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveAccount(Account account) {
        try{
            queryRunner.update("insert into account(name,money)values(?,?)",account.getName(),account.getMoney());
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateAccount(Account account) {
        try{
            queryRunner.update("update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteAccount(Integer id) {
        try{
            queryRunner.update("delete from account where id = ?",id);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
