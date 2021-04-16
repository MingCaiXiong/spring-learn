package top.xiongmingcai.aop;

import top.xiongmingcai.aop.service.UserService;
import top.xiongmingcai.aop.service.impl.UserServiceImpl;
import top.xiongmingcai.aop.service.proxy.UserServiceProxy;
import top.xiongmingcai.aop.service.proxy.UserServiceProxy1;

public class SpringApplication {
    public static void main(String[] args) {
        UserService userService = new UserServiceProxy1(new UserServiceProxy(new UserServiceImpl()));
        userService.createUser();
    }
}
