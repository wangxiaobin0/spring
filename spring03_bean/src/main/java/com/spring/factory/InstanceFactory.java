package com.spring.factory;

import com.spring.service.IAccountService;
import com.spring.service.impl.AccountServiceImpl;

public class InstanceFactory {

    public IAccountService getAccountServiceInstance() {
        return new AccountServiceImpl();
    }
}
