package top.xiongmingcai.ioc.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import top.xiongmingcai.ioc.dao.IUserDao;
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
//    @Qualifier("userDao")
    @Autowired//不在执行set方法
    private IUserDao udao;

    public UserService() {
        System.out.println("UserService.UserService" + this);
    }

    public IUserDao getUdao() {
        return udao;
    }

    public void setUdao(IUserDao udao) {
        this.udao = udao;
    }
}