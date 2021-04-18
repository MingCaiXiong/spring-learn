package top.xiongmingcai.jdbc.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.xiongmingcai.jdbc.dao.EmployeeDao;
import top.xiongmingcai.jdbc.entity.Employee;

import javax.annotation.Resource;
import java.util.List;
import java.util.ListIterator;

@Service
@Transactional
public class EmployeeService {
  @Resource private EmployeeDao employeeDao;
  @Resource private BatchService batchService;

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void setBatchService(BatchService batchService) {
        this.batchService = batchService;
    }
    @Transactional(propagation = Propagation.NOT_SUPPORTED , readOnly = true)
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
    public void batchDel() {
        List<Employee> employeeList = employeeDao.queryByDname("市场部");
        ListIterator iter = employeeList.listIterator();
        while (iter.hasNext()) {
            Employee next = (Employee)iter.next();
//            System.out.println("index: " + iter.nextIndex() + " value: " + iter.next());
            if (iter.nextIndex() ==3) {
                throw new RuntimeException("意料之外的错误");
            }
           employeeDao.delete( next.getEno());

        }
    }
    public void startImportJob(){
        batchService.importJob1();
        batchService.importJob2();
         System.out.println("批量导入成功!");
    }
}
