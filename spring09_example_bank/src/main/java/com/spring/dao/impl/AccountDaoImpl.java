package com.spring.dao.impl;

import com.spring.dao.IAccountDao;
import com.spring.domain.Account;
import com.spring.util.ConnectionUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {
    @Autowired
    ConnectionUtil connectionUtil;
    @Autowired
    QueryRunner queryRunner;

    @Override
    public List<Account> queryAll() {
        try {
            return queryRunner.query(connectionUtil.getThreadConnection(), "select * from account", new BeanListHandler<Account>(Account.class));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account queryAccountById(int id) {
        try {
            return queryRunner.query(connectionUtil.getThreadConnection(),"select * from account where id= ?", new BeanHandler<Account>(Account.class), id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveAccount(Account account) {
        try {
            queryRunner.update(connectionUtil.getThreadConnection(),"insert into account(name, money) values(?, ?)", account.getName(), account.getMoney());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            queryRunner.update(connectionUtil.getThreadConnection(),"update account set money=? where id=?", account.getMoney(), account.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteAccount(Account account) {
        try {
            queryRunner.update(connectionUtil.getThreadConnection(),"delete from account where id=?",  account.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account queryAccountByName(String name) {
        try {
            List<Account> accountList = queryRunner.query(connectionUtil.getThreadConnection(),"select * from account where name= ?", new BeanListHandler<Account>(Account.class), name);
            if (accountList.isEmpty()) {
                return null;
            }
            if (accountList.size() > 1) {
                throw new RuntimeException("结果集不唯一");
            }
            return accountList.get(0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
