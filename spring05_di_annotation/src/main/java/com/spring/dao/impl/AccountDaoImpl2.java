package com.spring.dao.impl;

import com.spring.dao.IAccountDao;
import org.springframework.stereotype.Repository;

@Repository("accountDao2")
public class AccountDaoImpl2 implements IAccountDao {
    @Override
    public void saveAccount() {
        System.out.println("保存了客户2222");
    }
}
