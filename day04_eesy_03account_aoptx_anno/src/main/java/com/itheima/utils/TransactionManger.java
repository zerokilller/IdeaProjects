package com.itheima.utils;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 和事物管理相关的工具类，他包含了开启事物，提交事物，回滚事物和释放事物。
 */
@Component("transactionManger")
@Aspect
public class TransactionManger {

    @Autowired
    private ConnectionUtils connectionUtils;

    @Pointcut("execution(* com.itheima.service.impl.*.*(..))")
    private void pt1(){}

    /**
     *@Description: 开启事物
     *@Author: 景文博
     *@Param:
     *@return:
     */
    public void beginTransaction(){
        try{
            connectionUtils.getThreadConnection().setAutoCommit(false);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     *@Description: 提交事物
     *@Author: 景文博
     *@Param:
     *@return:
     */
    public void commit(){
        try{
            connectionUtils.getThreadConnection().commit();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     *@Description: 回滚事物
     *@Author: 景文博
     *@Param:
     *@return:
     */
    public void rollback(){
        try{
            connectionUtils.getThreadConnection().rollback();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     *@Description: 释放事物
     *@Author: 景文博
     *@Param:
     *@return:
     */
    public void release(){
        try{
            //并不是真正把我们的连接关闭，而是将我们的连接还回池中
            connectionUtils.getThreadConnection().close();
            connectionUtils.removeConnection();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     *环绕通知
     */
    @Around("pt1()")
    public Object aroundAdvice(ProceedingJoinPoint pjp){
        Object retValue = null;
        try{
            //1.获取参数
            Object[] args = pjp.getArgs();
            //2.开启事物
            this.beginTransaction();
            //3.执行操作
            retValue = pjp.proceed(args);
            //4.提交事物
            this.commit();
            return retValue;
        }catch(Throwable t){
            //5.回滚事物
            this.rollback();
            throw  new RuntimeException(t);
        }finally {
            //6. 释放连接
            this.release();
        }
    }
}
