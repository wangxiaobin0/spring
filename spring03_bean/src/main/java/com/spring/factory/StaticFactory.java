package com.spring.factory;

import com.spring.service.IAccountService;
import com.spring.service.impl.AccountServiceImpl;

public class StaticFactory {
    public static IAccountService getAccountServiceStatic(){
        return new AccountServiceImpl();
    }
}
