package top.xiongmingcai.ioc.service;


import top.xiongmingcai.ioc.dao.UserDao;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2021-04-15 14:28:55
 */
public class UserService {
   private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void insertOneUser(){
        System.out.println("调用创建用户业务代码! ");
        userDao.insert();
    }
}