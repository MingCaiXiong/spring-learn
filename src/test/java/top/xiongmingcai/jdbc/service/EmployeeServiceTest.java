package top.xiongmingcai.jdbc.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class EmployeeServiceTest {
    @Resource
    private EmployeeService employeeService;

    @Test
    public void batchAdd() {
        employeeService.batchAdd();
    }
}