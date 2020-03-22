package com.spring.service.impl;

import com.spring.service.IAccountService;

import java.util.Date;

/**
 * Account业务层实现类
 */
public class AccountServiceImpl2 implements IAccountService {

    private String name;
    private Integer age;
    private Date birthday;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void saveAccount() {
        System.out.println(toString());
        System.out.println("保存了客户");
    }

    @Override
    public String toString() {
        return "AccountServiceImpl{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }
}
