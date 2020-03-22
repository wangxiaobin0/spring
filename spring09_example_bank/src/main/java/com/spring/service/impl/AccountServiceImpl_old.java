package com.spring.service.impl;

import com.spring.dao.IAccountDao;
import com.spring.domain.Account;
import com.spring.service.IAccountService;
import com.spring.util.TransactionManager;

import java.util.List;

public class AccountServiceImpl_old implements IAccountService {


    private IAccountDao accountDao;
    private TransactionManager transactionManager;

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> queryAll() {
        try {
            transactionManager.autoCommit();
            List<Account> accountList = accountDao.queryAll();
            transactionManager.commit();
            return accountList;
        } catch (Exception e) {
            transactionManager.rollback();
            throw new RuntimeException(e);
        } finally {
            transactionManager.realse();
        }
    }

    @Override
    public Account queryAccountById(int id) {
        try {
            transactionManager.autoCommit();
            Account account = accountDao.queryAccountById(id);
            transactionManager.commit();
            return account;
        } catch (Exception e) {
            transactionManager.rollback();
            throw new RuntimeException(e);
        } finally {
            transactionManager.realse();
        }
    }

    @Override
    public void saveAccount(Account account) {
        try {
            transactionManager.autoCommit();
            accountDao.saveAccount(account);
            transactionManager.commit();
        } catch (Exception e) {
            transactionManager.rollback();
            throw new RuntimeException(e);
        } finally {
            transactionManager.realse();
        }

    }

    @Override
    public void updateAccount(Account account) {
        try {
            transactionManager.autoCommit();
            accountDao.updateAccount(account);
            transactionManager.commit();
        } catch (Exception e) {
            transactionManager.rollback();
            throw new RuntimeException(e);
        } finally {
            transactionManager.realse();
        }
    }

    @Override
    public void deleteAccount(Account account) {
        try {
            transactionManager.autoCommit();
            accountDao.deleteAccount(account);
            transactionManager.commit();
        } catch (Exception e) {
            transactionManager.rollback();
            throw new RuntimeException(e);
        } finally {
            transactionManager.realse();
        }
    }

    @Override
    public void transfer(String sourceName, String targetName, Double money) {

        try {
            transactionManager.autoCommit();
            Account source = accountDao.queryAccountByName(sourceName);
            Account target = accountDao.queryAccountByName(targetName);

            source.setMoney(source.getMoney() - money);
            target.setMoney(target.getMoney() + money);

            accountDao.updateAccount(source);
            int i = 1 / 0;
            accountDao.updateAccount(target);
            transactionManager.commit();
        } catch (Exception e) {
            transactionManager.rollback();
            throw new RuntimeException(e);
        } finally {
            transactionManager.realse();
        }
    }
}
