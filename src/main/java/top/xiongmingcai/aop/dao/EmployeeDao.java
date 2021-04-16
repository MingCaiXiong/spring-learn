package top.xiongmingcai.aop.dao;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {
    public void insert(){
//        Integer sun = 1/0;
        System.out.println("新增员工数据");
    }
}
