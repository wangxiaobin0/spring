package com.spring.service.impl;


import com.spring.dao.IAccountDao;
import com.spring.domain.Account;
import com.spring.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

    @Override
    public List<Account> queryAll() {
        List<Account> accountList = accountDao.queryAll();
        return accountList;
    }

    @Override
    public Account queryAccountById(int id) {
        Account account = accountDao.queryAccountById(id);
        return account;
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

    @Override
    public void transfer(String sourceName, String targetName, Double money) {
        Account source = accountDao.queryAccountByName(sourceName);
        Account target = accountDao.queryAccountByName(targetName);

        source.setMoney(source.getMoney() - money);
        target.setMoney(target.getMoney() + money);

        accountDao.updateAccount(source);
        int i = 1 / 0;
        accountDao.updateAccount(target);
    }
}
