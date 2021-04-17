package top.xiongmingcai.jdbc.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.xiongmingcai.jdbc.entity.Employee;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class EmployeeDaoTest {
    @Resource
    private EmployeeDao employeeDao;
    @Test
    public void findById() {
        Employee employee = employeeDao.findById(1);
        System.out.println("employee = " + employee);
    }

    @Test
    public void queryByDname() {
        List<Employee> employeeList = employeeDao.queryByDname("市场部");
        System.out.println(employeeList);
    }

    @Test
    public void queryMapByDname() {
        List<Map<String, Object>> mapList = employeeDao.queryMapByDname("研发部");
        for (Map<String, Object> stringObjectMap : mapList) {
            System.out.println(stringObjectMap);
        }
    }

    @Test
    public void insert() {
        Employee employee = new Employee();
        employee.setEname("王晓燕");
        employee.setSalary(2000);
        employee.setDname("市场部");
        employee.setHiredate("2021-02-15");
        int updateRow = employeeDao.insert(employee);
        System.out.println("插入多少行 => " + updateRow);
    }


    @Test
    public void update() {
        Employee employee = employeeDao.findById(1);
        employee.setSalary(3000);
        int updateRow = employeeDao.update(employee);
        System.out.println("更新多少行 => " + updateRow);
    }

    @Test
    public void delete() {
        int delete = employeeDao.delete(1);

    }
}