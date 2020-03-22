package com.spring.dao.impl;

import com.spring.dao.IAccountDao;
import com.spring.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Account> queryAll() {
        return jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
    }

    @Override
    public Account queryAccountByName(String name) {
        return jdbcTemplate.queryForObject("select * from account where name like ?", new BeanPropertyRowMapper<Account>(Account.class), name);
    }

    @Override
    public Account queryAccountById(Integer id) {
        return jdbcTemplate.queryForObject("select * from account where id=?", new BeanPropertyRowMapper<Account>(Account.class), id);
    }

    @Override
    public Integer queryCount() {
        return jdbcTemplate.queryForObject("select count(id) from account", Integer.class);
    }

    @Override
    public void saveAccount(Account account) {
        jdbcTemplate.update("insert into account(name, money) values(?, ?)", account.getName(), account.getMoney());
    }

    @Override
    public void updateAccount(Account account) {
        jdbcTemplate.update("update account set money=? where id=?", account.getId(), account.getMoney());
    }

    @Override
    public void deleteAccount(Integer id) {
        jdbcTemplate.update("delete from account where id=?", id);
    }
}
