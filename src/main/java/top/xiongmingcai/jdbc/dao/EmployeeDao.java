package top.xiongmingcai.jdbc.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import top.xiongmingcai.jdbc.entity.Employee;


/**
 * (Employee)表数据库访问层
 *
 * @author makejava
 * @since 2021-04-17 10:47:57
 */
public class EmployeeDao {
    private JdbcTemplate  jdbcTemplate;

    public Employee findById(Integer eno){
        String sql = "select * from employee where eno = ?;";
        Employee employee = jdbcTemplate.queryForObject(sql,
                new Object[]{eno},
                new BeanPropertyRowMapper<Employee>(Employee.class));
        return employee;
    };

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}