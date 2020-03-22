package com.spring.dao.impl;

import com.spring.dao.IAccountDao;
import com.spring.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {

    @Autowired
    QueryRunner queryRunner;

    @Override
    public List<Account> queryAll() {
        try {
            return queryRunner.query("select * from account", new BeanListHandler<Account>(Account.class));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account queryAccountById(int id) {
        try {
            return queryRunner.query("select * from account where id= ?", new BeanHandler<Account>(Account.class), id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveAccount(Account account) {
        try {
            queryRunner.update("insert into account(name, money) values(?, ?)", account.getName(), account.getMoney());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            queryRunner.update("update account set money=? where id=?", account.getMoney(), account.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteAccount(Account account) {
        try {
            queryRunner.update("delete from account where id=?",  account.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
