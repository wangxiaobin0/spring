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
public class AccountServiceImplTest {
    @Autowired
    IAccountService accountService;

    @Test
    public void testTransfer() {
        accountService.transfer("dddd", "eeee", 50d);
    }

}
