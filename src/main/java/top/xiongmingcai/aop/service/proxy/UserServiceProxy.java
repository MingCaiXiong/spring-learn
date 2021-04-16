package top.xiongmingcai.aop.service.proxy;

import top.xiongmingcai.aop.service.UserService;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserServiceProxy implements UserService {
    private UserService userService;

    public UserServiceProxy(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void createUser() {
        System.out.println("========="+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSSS").format(new Date()));
        userService.createUser();
    }
}
