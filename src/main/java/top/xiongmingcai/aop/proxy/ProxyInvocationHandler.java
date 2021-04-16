package top.xiongmingcai.aop.proxy;

import top.xiongmingcai.aop.service.EmployeeService;
import top.xiongmingcai.aop.service.UserService;
import top.xiongmingcai.aop.service.impl.EmployeeServiceImpl;
import top.xiongmingcai.aop.service.impl.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProxyInvocationHandler implements InvocationHandler {

    private Object targetObject;//目标对象

    public ProxyInvocationHandler(Object targetObject) {
        this.targetObject = targetObject;
    }

    /**
     * 在 invoke ) 方法对目标对象进行增强
     *
     * @param proxy  代理类对象
     * @param method 目标方法对象
     * @param args   目标方法实际参数
     * @return 目标方法运行后返回值
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName() + "  >> ========="+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSSS").format(new Date()));

        Object ret = method.invoke(targetObject, args);
        return ret;
    }

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        ProxyInvocationHandler invocationHandler = new ProxyInvocationHandler(userService);
        //动态创建代理类
        UserService userServiceProxy = (UserService)Proxy.newProxyInstance(userService.getClass().getClassLoader(), userService.getClass().getInterfaces(), invocationHandler);
        userServiceProxy.createUser();

        //动态代理,必须实现接口才可以运行(强制要求)
        EmployeeService employeeService = new EmployeeServiceImpl();
        EmployeeService employeeServiceProxy = (EmployeeService) Proxy.newProxyInstance(employeeService.getClass().getClassLoader(), employeeService.getClass().getInterfaces(), new ProxyInvocationHandler(employeeService));
        employeeServiceProxy.createEmployee();
    }

}
