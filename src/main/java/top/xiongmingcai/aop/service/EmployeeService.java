package top.xiongmingcai.aop.service;

import org.springframework.stereotype.Service;
import top.xiongmingcai.aop.dao.EmployeeDao;

import javax.annotation.Resource;

@Service
public class EmployeeService {
    @Resource
    private EmployeeDao employeeDao;
    public void onBoarding(){
        System.out.println("执行员工入职业务逻辑");
        employeeDao.insert();
    }

    public EmployeeDao getEmployeeDao() {
        return employeeDao;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
