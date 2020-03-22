package com.spring.dao;

import com.spring.domain.Account;

import java.util.List;

/**
 * Account的持久层接口
 */
public interface IAccountDao {
    List<Account> queryAll();
    Account queryAccountById(Integer id);
    Account queryAccountByName(String name);
    Integer queryCount();
    void saveAccount(Account account);
    void updateAccount(Account account);
    void deleteAccount(Integer id);
}
