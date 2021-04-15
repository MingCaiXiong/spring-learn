package top.xiongmingcai.ioc.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
@Repository
@Scope(value = "prototype")
public class UserOraclDao implements IUserDao{
    public UserOraclDao() {
        System.out.println("UserOraclDao.UserOraclDao");
    }

    @Override
    public void joinDepartment() {

    }
}
