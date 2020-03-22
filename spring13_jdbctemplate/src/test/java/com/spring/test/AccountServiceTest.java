package com.spring.test;


import com.spring.domain.Account;
import com.spring.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class AccountServiceTest {
    @Autowired
    IAccountService accountService;

    @Test
    public void testQueryAll() {
        System.out.println("-------queryAll---------");
        System.out.println(accountService.queryAll());
    }

    @Test
    public void testQueryAccountById() {
        System.out.println("-------queryAccountById---------");
        System.out.println(accountService.queryAccountById(1));
    }

    @Test
    public void testQueryAccountByName() {
        System.out.println("-------queryAccountById---------");
        System.out.println(accountService.queryAccountByName("a"));
    }

    @Test
    public void testQueryCount() {
        System.out.println("-------queryAccountById---------");
        System.out.println(accountService.queryCount());
    }

    @Test
    public void testSaveAccount() {
        Account account = new Account();
        account.setName("zzz");
        account.setMoney(1234d);
        accountService.saveAccount(account);
        System.out.println("-------添加成功---------");
    }

    @Test
    public void testUpdateAccount() {
        Account account = new Account();
        account.setId(9);
        account.setMoney(4567d);
        accountService.updateAccount(account);
        System.out.println("-------更细成功---------");
    }

    @Test
    public void testDeleteAccount() {
        accountService.deleteAccount(9);
    }

}
