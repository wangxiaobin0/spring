package com.spring.service.impl;

import com.spring.service.IAccountService;

import java.util.*;

/**
 * Account业务层实现类
 */
public class AccountServiceImpl3 implements IAccountService {

    private String[] strings;
    private List<String> list;
    private Set<String> set;
    private Map<String, String> map;
    private Properties properties;
    private List<Date> dateList;
    private Map<String, Date> dateMap;

    public void setStrings(String[] strings) {
        this.strings = strings;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setDateList(List<Date> dateList) {
        this.dateList = dateList;
    }

    public void setDateMap(Map<String, Date> dateMap) {
        this.dateMap = dateMap;
    }

    @Override
    public void saveAccount() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "AccountServiceImpl3{" +
                "strings=" + Arrays.toString(strings) +
                ", list=" + list +
                ", set=" + set +
                ", map=" + map +
                ", properties=" + properties +
                ", dateList=" + dateList +
                ", dateMap=" + dateMap +
                '}';
    }
}
