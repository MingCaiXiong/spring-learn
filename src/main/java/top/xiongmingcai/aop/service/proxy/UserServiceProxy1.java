package top.xiongmingcai.aop.service.proxy;

import top.xiongmingcai.aop.service.UserService;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserServiceProxy1 implements UserService {
    private UserService userService;

    public UserServiceProxy1(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void createUser() {
        userService.createUser();
        System.out.println("=====后置扩展功能====");
    }
}
