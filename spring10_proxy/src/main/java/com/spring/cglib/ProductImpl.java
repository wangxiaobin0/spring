package com.spring.cglib;

import com.spring.proxy.IProducer;

public class ProductImpl{
    public void sale(Float money) {
        System.out.println("出售电脑,赚钱" + money);
    }

    public void afterSale(Float money) {
        System.out.println("提供售后,赚钱:" + money);
    }
}
