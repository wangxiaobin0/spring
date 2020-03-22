package com.spring.service.impl;

import com.spring.dao.IAccountDao;
import com.spring.domain.Account;
import com.spring.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("accountService")
@Transactional
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

    @Override
    public void transfer(String sourceName, String targetName, Double money) {
        Account sourceAccount = accountDao.queryAccountByName(sourceName);
        Account targetAccount = accountDao.queryAccountByName(targetName);

        sourceAccount.setMoney(sourceAccount.getMoney() - money);
        targetAccount.setMoney(targetAccount.getMoney() + money);
        int i = 1 / 0;
        accountDao.updateAccount(sourceAccount);
        accountDao.updateAccount(targetAccount);
    }
}
