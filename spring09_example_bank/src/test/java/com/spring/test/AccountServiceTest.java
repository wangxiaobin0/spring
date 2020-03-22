package com.spring.test;

import com.spring.dao.IAccountDao;
import com.spring.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class AccountServiceTest {

    @Autowired
    IAccountService accountService;

    @Test
    public void testTransfer() {
        accountService.transfer("aaa", "ccc", 1000d);
    }
}
