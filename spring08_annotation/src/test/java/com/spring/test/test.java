package com.spring.test;


import com.spring.config.SpringConfiguration;
import com.spring.domain.Account;
import com.spring.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * spring整合junit
 *      问题: 使用@Test注解的方法在执行时不会加载容器
 *      解决:
 *          1.导入spring-test.jar
 *          2.使用junit提供的@RunWith注解替换成spring提供的.
 *          3.使用@ContextConfiguration告知spring的运行器容器的创建是基于xml还是注解,并说明位置.
 *              locations:指定xml文件的位置.加上classpath关键字,表明在类路径下.
 *              classes:指定主配置类的所在位置
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class test {

    @Autowired
    private IAccountService accountService;

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
