package com.itheima.utils;


/**
 * 和事物管理相关的工具类，他包含了开启事物，提交事物，回滚事物和释放事物。
 */
public class TransactionManger {

    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
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
}
