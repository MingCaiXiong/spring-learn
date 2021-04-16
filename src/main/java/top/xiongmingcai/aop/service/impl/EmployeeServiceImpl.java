package top.xiongmingcai.aop.service.impl;

import top.xiongmingcai.aop.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public void createEmployee() {
        System.out.println("执行创建员工逻辑--->");
    }
}
