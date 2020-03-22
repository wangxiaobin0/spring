package com.spring.service.impl;

import com.spring.dao.IAccountDao;
import com.spring.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.Date;

/**
 * Account业务层实现类
 *
 *
 * <bean id="accountService" class="com.spring.service.impl.AccountServiceImpl" scope="" init-method="" destroy-method="">
 *      <property name="" value|ref=""></property>
 * </bean>
 *
 *  用于创建对象的注解:
 *      @Component: 把当前类的对象放入spring容器中
 *          value:指定bean的id.默认为类名且首字母小写
 *      @Controller: 一般用在控制层
 *      @Service: 一般用在业务层
 *      @Repository: 一般用在持久层
 *      以上三个注解作用于@Component作用相同
 *  用于注入数据的注解:
 *      @Autowired: 自动按照类型注入.先与容器中的对象类型匹配,多个匹配时再与id匹配.
 *          只要容器(key-value)中有唯一的一个bean对象类型与要注入的变量类型匹配(包括实现接口和继承父类),就可以注入成功.
 *          当容器中多个bean对象匹配时,再以变量名作为bean的id匹配,没有匹配的话就报错.
 *          可以出现在变量上,也可以在方法上.也可以其他别的位置,但这两个位置最常用.
 *      @Qualifier: 在自动按照类型注入的基础上按照bean的id注入.
 *              value:bean对象的id
 *          作用于变量时不能单独使用,作用于方法时可以单独使用.
 *      @Resource: 直接根据bean对象的id注入.
 *          name: bean对象的id.
 *      ======以上注解适用于bean对象的注入==========
 *      @Value: 给基本数据类和String类型注入数据
 *          value:指定数据的值.可以使用spring中的SpEL表达式${}.
 *          使用注解注入时,set方法就不是必须的了.
 *  用于作用范围的注解:
 *      @Scope: 用于指定bean对象的作用范围.常用取值:singleton(默认)/prototype
 *  用于生命周期的注解:
 *      @PostConstruct: 指定初始化方法
 *      @PreDestroy: 指定销毁方法
 */
@Service("accountService")
@Scope("singleton")
public class AccountServiceImpl implements IAccountService {
//    @Autowired
//    @Qualifier("accountDao1")
    @Resource(name = "accountDao2")
    private IAccountDao accountDao;
    @Value("1")
    private Integer x;

    public void saveAccount() {
        accountDao.saveAccount();
        System.out.println(x);
    }
    @PostConstruct
    public void init() {
        System.out.println("初始化...");
    }
    @PreDestroy
    public void destroy() {
        System.out.println("销毁...");
    }
}
