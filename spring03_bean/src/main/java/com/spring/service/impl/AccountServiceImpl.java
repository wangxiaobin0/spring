package com.spring.service.impl;

import com.spring.service.IAccountService;

/**
 * Account业务层实现类
 */
public class AccountServiceImpl implements IAccountService {
    public AccountServiceImpl() {
        System.out.println("创建了对象");
    }

    public void saveAccount() {
        System.out.println("保存了客户");
    }

    public void init() {
        System.out.println("init");
    }
    public void destroy() {
        System.out.println("destroy");
    }
}
