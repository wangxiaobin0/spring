package com.spring.service.impl;

import com.spring.service.IAccountService;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;

@Service("accountService")

public class AccountServiceImpl implements IAccountService {
    @Override
    public void saveAccount() {
        System.out.println("保存了账户");
    }

    @Override
    public void updateAccount(int i) {
        System.out.println("更新了用户");
    }

    @Override
    public int deleteAccount() {
        System.out.println("删除了用户");
        return 0;
    }
}
