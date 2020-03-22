package com.spring.test;

import com.spring.dao.IAccountDao;
import com.spring.factory.BeanFactory;
import com.spring.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        IAccountService accountService = (IAccountService) BeanFactory.getBean("IAccountService");
        accountService.saveAccount();
        /*ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        IAccountService accountService = (IAccountService) ac.getBean("accountService");
        accountService.saveAccount();*/
    }
}
