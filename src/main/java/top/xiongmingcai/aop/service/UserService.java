package top.xiongmingcai.aop.service;

import top.xiongmingcai.aop.dao.UserDao;

public class UserService {
    private UserDao userDao;

    public  void createUser(){
        //为触发环绕通知
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行创建用户逻辑");
        userDao.insert();
    }

    public String validationPassword(String type, Integer length){
        System.out.println("使用"+type + "加密" + "长度为:"+length);
        return "sdafdsaf";
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
