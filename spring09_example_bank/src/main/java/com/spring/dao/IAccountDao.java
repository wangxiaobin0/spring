package com.spring.dao;

import com.spring.domain.Account;

import java.util.List;

public interface IAccountDao {
    List<Account> queryAll();

    Account queryAccountById(int id);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Account account);

    Account queryAccountByName(String name);
}
