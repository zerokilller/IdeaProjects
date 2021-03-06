package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.dao.impl.AccountDaoImpl;
import com.itheima.service.IAccountService;

/**
 *账户的业务层实现类
 *  <bean id="accountService" class="com.itheima.service.impl.AccountServiceImpl"
 *  scope="" init-method="" destroy-method="">
 *      <property name="" value="" ｜ ref=""></property>
 *  </bean>
 *用于对象创建的:他们的作用就和在xml配置文件中编写一个<bean>标签实现的功能是一样的。
 *用于注入数据的:他们的作用就和在xml配置文件中的bean标签中写一个<property>标签的作用是一样的。
 *用于改变作用范围的:他们的作用就和在bean标签中使用scope属性实现的功能
 */








public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao = new AccountDaoImpl();
    public AccountServiceImpl(){
        System.out.println("对象创建了");
    }
    @Override
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
