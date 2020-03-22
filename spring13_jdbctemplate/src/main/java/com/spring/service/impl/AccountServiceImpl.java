package com.spring.service.impl;

import com.spring.dao.IAccountDao;
import com.spring.domain.Account;
import com.spring.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {
    @Autowired
    IAccountDao accountDao;

    @Override
    public List<Account> queryAll() {
        return accountDao.queryAll();
    }

    @Override
    public Account queryAccountById(Integer id) {
        return accountDao.queryAccountById(id);
    }

    @Override
    public Account queryAccountByName(String name) {
        return accountDao.queryAccountByName("%" + name + "%");
    }

    @Override
    public Integer queryCount() {
        return accountDao.queryCount();
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
    public void deleteAccount(Integer id) {
        accountDao.deleteAccount(id);
    }
}
