package com.itheima.factory;


import com.itheima.dao.IAccountDao;
import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import com.itheima.utils.TransactionManger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 用于创建Service的代理对象的工厂
 */
public class BeanFactory {

    private IAccountService accountService;
    private TransactionManger transactionManger;

    public final void  setTransactionManger(TransactionManger transactionManger) {
        this.transactionManger = transactionManger;
    }

    public void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    /**
     *@Description: 获取Service的代理对象
     *@Author: 景文博
     *@Param: 
     *@return:
     */
    public IAccountService getAccountService() {
        Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(), new InvocationHandler() {
                    /**
                     *@Description: 添加事物的支持
                     *@Author: 景文博
                     *@Param: []
                     *@return:
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object ret = null;
                        try{
                            //1.开启事物
                            transactionManger.beginTransaction();
                            //2.执行操作
                            ret = method.invoke(accountService,args);
                            //2.7提交事物
                            transactionManger.commit();
                        }catch(Exception e){
                            //3.回滚操作
                            transactionManger.rollback();
                            e.printStackTrace();
                        }finally {
                            //4.释放连接
                            transactionManger.release();
                        }
                        return ret;
                    }
                }
        );
        return accountService;
    }
}
