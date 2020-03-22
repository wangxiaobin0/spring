package com.spring.service.impl;

import com.spring.dao.IAccountDao;
import com.spring.domain.Account;
import com.spring.service.IAccountService;

import java.util.List;

public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> queryAll() {
        return accountDao.queryAll();
    }

    @Override
    public Account queryAccountById(int id) {
        return accountDao.queryAccountById(id);
    }

    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    @Override
    public void deleteAccount(Account account) {
        accountDao.deleteAccount(account);
    }
}
