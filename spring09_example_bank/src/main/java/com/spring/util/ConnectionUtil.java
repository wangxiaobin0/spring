package com.spring.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

@Component
public class ConnectionUtil {
    private ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

    @Autowired
    private DataSource ds;

    public Connection getThreadConnection() {
        try {
            Connection connection = threadLocal.get();
            if (connection == null) {
                connection = ds.getConnection();
                threadLocal.set(connection);
            }
            return connection;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void unBind() {
        threadLocal.remove();
    }
}
