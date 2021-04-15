package top.xiongmingcai.ioc.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao implements IUserDao{
    public UserDao() {
        System.out.println("UserDao.UserDao"+this);
    }


    @Override
    public void joinDepartment() {

    }
}