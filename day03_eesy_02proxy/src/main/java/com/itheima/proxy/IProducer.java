package com.itheima.proxy;


/**
 * 对生产厂家要求的接口
 */
public interface IProducer{

    /**
     *@Description: 销售
     *@Author: 景文博
     *@Param: money
     *@return:
     */
    public void saleProduct(float money);

    /**
     *@Description: 售后
     *@Author: 景文博
     *@Param: money
     *@return:
     */
    public void afterSale(float money);
}
