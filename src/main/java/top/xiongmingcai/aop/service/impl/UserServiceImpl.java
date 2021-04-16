package top.xiongmingcai.aop.service.impl;

import top.xiongmingcai.aop.service.UserService;

public class UserServiceImpl implements UserService{
    @Override
    public void createUser() {
        System.out.println("执行创建用户逻辑--->");
    }
}
