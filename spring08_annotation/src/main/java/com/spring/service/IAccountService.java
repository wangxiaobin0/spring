package com.spring.service;

import com.spring.domain.Account;

import java.util.List;

public interface IAccountService {
    List<Account> queryAll();

    Account queryAccountById(int id);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Account account);
}
