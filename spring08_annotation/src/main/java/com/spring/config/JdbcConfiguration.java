package com.spring.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;


public class JdbcConfiguration {

    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Bean(name = "queryRunner")
    @Scope("prototype")
    public QueryRunner getQueryRunner(@Qualifier("ds1") DataSource dataSource) {
        return new QueryRunner(dataSource);
    }

    @Bean("ds1")
    public DataSource getDataSource() {
        try {
            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            dataSource.setDriverClass(driver);
            dataSource.setJdbcUrl(url);
            dataSource.setUser(username);
            dataSource.setPassword(password);
            return dataSource;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Bean("ds2")
    public DataSource getDataSource2() {
        try {
            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            dataSource.setDriverClass(driver);
            dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/mybatis1?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8");
            dataSource.setUser(username);
            dataSource.setPassword(password);
            return dataSource;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
