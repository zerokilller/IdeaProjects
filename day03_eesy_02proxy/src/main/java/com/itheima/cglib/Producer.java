package com.itheima.cglib;

import com.itheima.proxy.IProducer;

/**
 * 一个生产者
 */
public class Producer {
    /**
     *@Description: 销售
     *@Author: 景文博
     *@Param: money
     *@return:
     */
    public void saleProduct(float money){
        System.out.println("销售产品，并拿到钱"+money);
    }

    /**
     *@Description: 售后
     *@Author: 景文博
     *@Param: money
     *@return:
     */
    public void afterSale(float money){
        System.out.println("售后提供服务，并拿到钱"+money);
    }



}
