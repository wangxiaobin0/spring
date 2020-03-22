package com.spring.test;

import com.spring.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        //构造方法注入
        IAccountService accountService = (IAccountService) ac.getBean("accountService");
        accountService.saveAccount();

        //set方法注入
        IAccountService accountService2 = (IAccountService) ac.getBean("accountService2");
        accountService2.saveAccount();

        //注入集合数据
        IAccountService accountService3 = (IAccountService) ac.getBean("accountService3");
        accountService3.saveAccount();
    }
}
