package top.xiongmingcai.aop.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    public void insert(){
        System.out.println("新增用户数据");
    }
}
