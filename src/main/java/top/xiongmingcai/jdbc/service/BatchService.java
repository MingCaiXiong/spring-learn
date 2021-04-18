package top.xiongmingcai.jdbc.service;

import top.xiongmingcai.jdbc.dao.EmployeeDao;
import top.xiongmingcai.jdbc.entity.Employee;

public class BatchService {
  private EmployeeDao employeeDao;

  public EmployeeDao getEmployeeDao() {
    return employeeDao;
  }

  public void setEmployeeDao(EmployeeDao employeeDao) {
    this.employeeDao = employeeDao;
  }

  public void importJob1() {

    for (int i = 1; i <= 10; i++) {
      //            if (i == 3) {
      //                throw new RuntimeException("意料之外的错误");
      //            }
      Employee employee = new Employee();
      employee.setEname("employee" + i);
      employee.setSalary(4000);
      employee.setHiredate("2021-02-15");
      employee.setDname("销售部");
      employee.setEno(1000 + i);
      employeeDao.insert(employee);
    }
    System.out.println("BatchService.importJob1");
  }

  public void importJob2() {

    for (int i = 1; i <= 10; i++) {
      if (i == 3) {
        throw new RuntimeException("意料之外的错误");
      }
      Employee employee = new Employee();
      employee.setEname("employee" + i);
      employee.setSalary(4000);
      employee.setHiredate("2021-02-15");
      employee.setDname("客服部");
      employee.setEno(1000 + i);
      employeeDao.insert(employee);
    }
    System.out.println("BatchService.importJob2");
  }
}
