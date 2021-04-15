package top.xiongmingcai.ioc.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
@Repository
//@Primary
public class UserOraclDao implements IUserDao{
    public UserOraclDao() {
        System.out.println("UserOraclDao.UserOraclDao");
    }
}
