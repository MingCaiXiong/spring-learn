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
}