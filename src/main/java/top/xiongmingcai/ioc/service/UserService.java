package top.xiongmingcai.ioc.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.xiongmingcai.ioc.dao.UserDao;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2021-04-15 08:36:56
 */
@Service
public class UserService {
    //spring ioc 容器会自动通过反射技术将属性private修饰符自动改为public,直接进行赋值
    @Autowired//不在执行set方法
    private UserDao userDao;

    public UserService() {
        System.out.println("UserService.UserService" + this);
    }

    public UserDao getUserDao() {
        return userDao;
    }
//    @Autowired
    //如果转配注解放在set 方法上,则自动按类型?名称对Set方法参数进行注入
    public void setUserDao(UserDao userDao) {
        System.out.println("UserService.setUserDao" + this);
        this.userDao = userDao;
    }
}