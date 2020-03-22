package com.spring.service.impl;

import com.spring.dao.IAccountDao;
import com.spring.dao.impl.AccountDaoImpl;
import com.spring.service.IAccountService;

/**
 * Account业务层实现类
 */
public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao = new AccountDaoImpl();
    public void saveAccount() {
        accountDao.saveUser();
    }
}
