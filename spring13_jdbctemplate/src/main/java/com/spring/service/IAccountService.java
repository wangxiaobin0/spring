package com.spring.service;

import com.spring.domain.Account;

import java.util.List;

public interface IAccountService {
    List<Account> queryAll();
    Account queryAccountById(Integer id);
    Account queryAccountByName(String name);
    Integer queryCount();
    void saveAccount(Account account);
    void updateAccount(Account account);
    void deleteAccount(Integer id);
}
