package top.xiongmingcai.ioc.service;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import top.xiongmingcai.ioc.dao.IUserDao;

import javax.annotation.Resource;

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
//    @Autowired//不在执行set方法
//    @Resource(name = "userDao")
    @Resource
    private IUserDao dao;

    public void setDao(IUserDao dao) {
        this.dao = dao;
    }

    public UserService() {
        System.out.println("UserService.UserService" + this);
    }

    public IUserDao getUdao() {
        return dao;
    }

    public void setUdao(IUserDao udao) {
        this.dao = udao;
    }

    public  void  show(){
        System.out.println("userOraclDao = " + dao);
    }
}