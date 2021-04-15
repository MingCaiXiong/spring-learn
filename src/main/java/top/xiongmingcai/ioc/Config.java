package top.xiongmingcai.ioc;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import top.xiongmingcai.ioc.controller.UserController;
import top.xiongmingcai.ioc.dao.EmployeeDao;
import top.xiongmingcai.ioc.dao.UserDao;
import top.xiongmingcai.ioc.service.UserService;

@Configuration//当前是一个配置类,用于替代 applicationContext.xml
@ComponentScan(basePackages = "top.xiongmingcai") //兼容注解ioc容器实例化模式
public class Config {
    @Primary
    @Bean//java Config 利用方法创建对象,将方法返回对象放入容器,beanId=方法名
    public UserDao userDao0() {
        return new UserDao();
    }
    @Bean//java Config 利用方法创建对象,将方法返回对象放入容器,beanId=方法名
    public UserDao userDao1() {
        return new UserDao();
    }

    @Bean
    //先按name 尝试注入,name不存在则类型注入
    public UserService userService(@Qualifier("userDao1") UserDao dao, EmployeeDao employeeDao) {
        UserService userService = new UserService();
        System.out.println(userService + "     <===已创建userService :");
        userService.setUserDao(dao);
        userService.setEmployeeDao(employeeDao);
        System.out.println(dao + "     <===调用 : setUserDao");
        System.out.println(employeeDao + "     <===调用 : setEmployeeDao");
        return userService;
    }

    @Bean
    public UserController userController(UserService userService) {
        UserController userController = new UserController();
        System.out.println(userController + "     <===已创建userController :");
        userController.setUserService(userService);
        System.out.println(userService + "     <===调用 : setUserService");
        return userController;
    }
}
