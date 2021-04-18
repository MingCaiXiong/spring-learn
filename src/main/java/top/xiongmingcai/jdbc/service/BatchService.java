package top.xiongmingcai.jdbc.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.xiongmingcai.jdbc.dao.EmployeeDao;
import top.xiongmingcai.jdbc.entity.Employee;

import javax.annotation.Resource;

@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class BatchService {
  @Resource private EmployeeDao employeeDao;

  public EmployeeDao getEmployeeDao() {
    return employeeDao;
  }

  public void setEmployeeDao(EmployeeDao employeeDao) {
    this.employeeDao = employeeDao;
  }
  @Transactional(propagation = Propagation.REQUIRES_NEW)
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
  @Transactional(propagation = Propagation.REQUIRES_NEW)
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
