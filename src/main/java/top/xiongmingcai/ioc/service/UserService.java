package top.xiongmingcai.ioc.service;


import top.xiongmingcai.ioc.dao.EmployeeDao;
import top.xiongmingcai.ioc.dao.UserDao;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2021-04-15 08:36:56
 */
public class UserService {

    private UserDao userDao;
    private EmployeeDao employeeDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public EmployeeDao getEmployeeDao() {
        return employeeDao;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}