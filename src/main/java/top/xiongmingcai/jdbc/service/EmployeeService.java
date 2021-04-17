package top.xiongmingcai.jdbc.service;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import top.xiongmingcai.jdbc.dao.EmployeeDao;
import top.xiongmingcai.jdbc.entity.Employee;

public class EmployeeService {
    private EmployeeDao employeeDao;
    private DataSourceTransactionManager transactionManager;

    public DataSourceTransactionManager getTransactionManager() {
        return transactionManager;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void setTransactionManager(DataSourceTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public EmployeeDao getEmployeeDao() {
        return employeeDao;
    }


    public void batchAdd() {
        // 定义了事务默认的标准配置
        TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
        // 开始一个事务，返回事务状态，事务状态说明当前事务的执行阶段
        TransactionStatus status = transactionManager.getTransaction(transactionDefinition);
        try {
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
            // 执行成功，提交事务
            transactionManager.commit(status);
        } catch (RuntimeException e) {
            // 执行失败，进行回滚
            transactionManager.rollback(status);
            e.printStackTrace();
            /*throw e; // 异常交由调用方处理*/

        }

    }


}
