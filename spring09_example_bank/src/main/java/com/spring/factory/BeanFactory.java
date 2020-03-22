package com.spring.factory;

import com.spring.service.IAccountService;
import com.spring.util.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BeanFactory {
    @Autowired
    private IAccountService accountService;
    @Autowired
    private TransactionManager transactionManager;
    public IAccountService getAccountService() {
        IAccountService accountServiceProxy = (IAccountService)Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                try {
                    transactionManager.autoCommit();
                    Object retValue = method.invoke(accountService, objects);
                    transactionManager.commit();
                    return retValue;
                } catch (Exception e) {
                    transactionManager.rollback();
                    throw new RuntimeException(e);
                } finally {
                    transactionManager.realse();
                }
            }
        });
        return accountServiceProxy;
    }

    public void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }
}
