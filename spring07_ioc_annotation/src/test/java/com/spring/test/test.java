package com.spring.test;

import com.spring.domain.Account;
import com.spring.service.IAccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

    private ApplicationContext ac;
    private IAccountService accountService;

    @Before
    public void testBefore() {
        ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        accountService = (IAccountService) ac.getBean("accountService");
    }

    @Test
    public void testQueryAll() {
        System.out.println(accountService.queryAll());
    }

    @Test
    public void testQueryAccountById() {
        System.out.println(accountService.queryAccountById(2));
    }

    @Test
    public void testSaveAccount() {
        Account account = new Account();
        account.setName("ddd");
        account.setMoney(1000.00);
        accountService.saveAccount(account);

    }

    @Test
    public void testUpdateAccount() {
        Account account = new Account();
        account.setId(2);
        account.setMoney(2000.0);
        accountService.updateAccount(account);
    }

    @Test
    public void testDeleteAccount() {
        Account account = new Account();
        account.setId(6);
        accountService.deleteAccount(account);
    }
}
