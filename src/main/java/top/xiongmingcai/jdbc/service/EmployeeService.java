package top.xiongmingcai.jdbc.service;

import top.xiongmingcai.jdbc.dao.EmployeeDao;
import top.xiongmingcai.jdbc.entity.Employee;

public class EmployeeService {
    private EmployeeDao employeeDao;

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }


    public void batchAdd() {
        Employee employee = new Employee();
        for (int i = 1; i <= 10; i++) {
            if (i == 3) {
                throw new RuntimeException("意料之外的错误");
            }
            employee.setEname("employee" + i);
            employee.setSalary(4000);
            employee.setHiredate("2021-02-15");
            employee.setDname("市场部");
            employee.setEno(1000 + i);
            employeeDao.insert(employee);
        }

    }
}
