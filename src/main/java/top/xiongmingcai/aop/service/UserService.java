package top.xiongmingcai.aop.service;

import top.xiongmingcai.aop.dao.UserDao;

public class UserService {
    private UserDao userDao;

    public  void createUser(){
        System.out.println("执行创建用户逻辑");
        userDao.insert();
    }

    public String validationPassword(String type, Integer length){
        System.out.println("效验密码");
        return "sdafdsaf";
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
