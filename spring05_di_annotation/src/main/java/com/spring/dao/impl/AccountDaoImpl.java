package com.spring.dao.impl;

import com.spring.dao.IAccountDao;
import org.springframework.stereotype.Repository;

@Repository("accountDao1")
public class AccountDaoImpl implements IAccountDao {
    @Override
    public void saveAccount() {
        System.out.println("保存了客户1111");
    }
}
