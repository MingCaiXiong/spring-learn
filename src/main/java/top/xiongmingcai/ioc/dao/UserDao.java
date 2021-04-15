package top.xiongmingcai.ioc.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    public UserDao() {
        System.out.println("UserDao.UserDao"+this);
    }
}