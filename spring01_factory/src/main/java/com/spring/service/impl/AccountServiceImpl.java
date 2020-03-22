package com.spring.service.impl;

import com.spring.dao.IAccountDao;
import com.spring.dao.impl.AccountDaoImpl;
import com.spring.factory.BeanFactory;
import com.spring.service.IAccountService;

/**
 * Account业务层实现类
 */
public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("IAccountDao");
    public void saveAccount() {
        accountDao = accountDao == null ? (IAccountDao) BeanFactory.getBean("IAccountDao") : accountDao;
        accountDao.saveUser();
    }
}
