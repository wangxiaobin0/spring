package com.spring.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ContextConfiguration
@ComponentScan(basePackages = "com.spring")
@Import({JdbcConfig.class, TransactionConfig.class})
@PropertySource("jdbc.properties")
@EnableTransactionManagement
public class SpringConfiguration {
}
