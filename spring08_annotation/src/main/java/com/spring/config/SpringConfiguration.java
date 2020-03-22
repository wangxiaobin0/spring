package com.spring.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

/**
 * Spring配置类:作用和applicationContext.xml一样
 * @Configuration: 声明当前类为配置类
 *
 * @ComponentScan: 指定创建容器时需要扫描的包
 *      value: 需要扫描的包的全限定包名
 *      basePackages: 与value一样
 *
 * @Bean: 把方法的返回值作为bean对象放入容器中
 *      name: bean对象的id.默认值为方法名.
 *      当使用@Bean注解的方法有参数(所有数据类型都算)时,spring会自动到容器中匹配,匹配规则与@Autowired一致,匹配不到是会报错.
 *
 * @Import: 指定其他的配置类
 *      value: 配置类的字节码.
 *      使用了@Import注解之后,有@Import注解的类就是主配置类,导入的是子配置类.
 *      使用AnnotationConfigApplicationContext加载配置文件时,作为参数传入的配置类字节码文件是并列关系.
 *
 * @PropertySource: 指定properties文件
 *      value: properties文件的路径(classpath:包名)和名称.
 *      使用该注解指定properties文件后,就可以使用SpEL表达式获取properties文件中的值.
 */

@Configuration
@ComponentScan({"com.spring"})
@Import(JdbcConfiguration.class)
@PropertySource("classpath:jdbc.properties")
public class SpringConfiguration {


}
