package com.spring.test;

import com.spring.dao.IAccountDao;
import com.spring.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        //ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        //声明周期相关注解
        IAccountService accountService = (IAccountService) ac.getBean("accountService");
        accountService.saveAccount();
        ac.close();

        /*
        //依赖注入
        IAccountService accountService = (IAccountService) ac.getBean("accountService");
        accountService.saveAccount();
         */

        /*
        //创建对象
        IAccountService accountService = (IAccountService) ac.getBean("accountService");
        System.out.println(accountService);

        IAccountDao accountDao = (IAccountDao) ac.getBean("accountDao");
        System.out.println(accountDao);

         */



    }
}
