package top.xiongmingcai.ioc.controller;


import org.springframework.stereotype.Controller;
import top.xiongmingcai.ioc.service.UserService;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2021-04-15 08:36:58
 */
public class UserController {

    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}