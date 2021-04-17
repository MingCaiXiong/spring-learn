package top.xiongmingcai.jdbc.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import top.xiongmingcai.jdbc.entity.Employee;

import java.util.List;
import java.util.Map;


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

    // 查询结果中多条记录转换为对应对象，我们可以使用query()进行查询，
    public List<Employee> queryByDname(String dname){
        String sql = "select * from employee where dname = ?;";
        return jdbcTemplate.query(sql,
                new Object[]{dname},
                new BeanPropertyRowMapper<>(Employee.class));
    }
    // 很多字段名是没有实体属性的，无法进行实体类映射，我们可以使用queryForList()进行查询，这个结果会被封装成map对象
    public List<Map<String, Object>>  queryMapByDname(String dname){
        String sql = "select dname as dnme,  salary as s  from employee where dname = ?";
        //没有实体类对应的情况下queryForList将查询结果作为map进行封装
        return jdbcTemplate.queryForList(sql, dname);
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}