package com.spring.test;

import com.spring.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        /**
         * ApplicationContext接口的实现类
         *  ClassPathXmlApplicationContext:加载类路径下的配置文件.
         *  FileSystemXmlApplicationContext:加载磁盘上任意位置的配置文件.
         *  AnnotationConfigApplicationContext:
         *  ----------------------
         * ApplicationContext和BeanFactory
         *  ApplicationContext
         *      单例对象适用.
         *      在创建核心容器时,创建对象采用的策略时立即加载.即一读取完就立即加载配置文件中配置的所有对象.
         *  BeanFactory
         *      多例对象适用.
         *      在创建核心容器时,创建对象采用的策略时延迟加载.即使用id获取对象时,才真正创建对象.
         */

        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        //默认构造函数创建对象
        IAccountService accountService = (IAccountService) ac.getBean("accountService");
        System.out.println(accountService);
        /*
        //使用工厂类的非静态方法创建对象
        IAccountService accountServiceInstance = (IAccountService) ac.getBean("accountServiceInstance");
        System.out.println(accountServiceInstance);
        //使用工厂类的静态方法创建对象
        IAccountService accountServiceStatic = (IAccountService) ac.getBean("accountServiceStatic");
        System.out.println(accountServiceStatic);

         */
    }
}
