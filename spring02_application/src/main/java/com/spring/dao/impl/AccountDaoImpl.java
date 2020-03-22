package com.spring.dao.impl;

import com.spring.dao.IAccountDao;

/**
 * Account持久层实现类
 */
public class AccountDaoImpl implements IAccountDao {

    public void saveUser() {
        System.out.println("保存了账户");
    }
}
