package com.spring.proxy;

public class ProductImpl implements IProducer {
    @Override
    public void sale(Float money) {
        System.out.println("出售电脑,赚钱" + money);
    }

    @Override
    public void afterSale(Float money) {
        System.out.println("提供售后,赚钱:" + money);
    }
}
