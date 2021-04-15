package top.xiongmingcai.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.xiongmingcai.ioc.controller.UserController;
import top.xiongmingcai.ioc.dao.UserDao;
import top.xiongmingcai.ioc.service.UserService;

@Configuration//当前是一个配置类,用于替代 applicationContext.xml
public class Config {
    @Bean//java Config 利用方法创建对象,将方法返回对象放入容器,beanId=方法名
    public UserDao userDao() {
        return new UserDao();
    }

    @Bean
    //先按name 尝试注入,name不存在则类型注入
    public UserService userService(UserDao userDao) {
        UserService userService = new UserService();
        System.out.println(userService + "     <===已创建userService :");
        userService.setUserDao(userDao);
        System.out.println(userDao + "     <===调用 : setUserDao");
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
