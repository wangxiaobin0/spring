package com.spring.util;

import org.springframework.beans.factory.annotation.Autowired;

public class TransactionManager {

    @Autowired
    ConnectionUtil connectionUtil;

    public void autoCommit() {
        try {
            connectionUtil.getThreadConnection().setAutoCommit(false);
            System.out.println("开启手动提交事务");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void rollback() {
        try {
            connectionUtil.getThreadConnection().rollback();
            System.out.println("事务回滚");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void commit() {
        try {
            connectionUtil.getThreadConnection().commit();
            System.out.println("事务提交");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void realse() {
        try {

            connectionUtil.getThreadConnection().close();
            connectionUtil.unBind();
            System.out.println("释放Connection");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
