package top.xiongmingcai.aop.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
@Component //标记当前类为组件
@Aspect //说明点前类是切面类
//切面类
public class MethodAspect {
    //切面方法,用于扩展额外功能
    //JoinPoint 连接点 通过连接点可以获取目标类/方法的信息
    @Before("execution(* top.xiongmingcai..*.*(..)))")
    public void printExecutionTime(JoinPoint joinPoint) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String now = simpleDateFormat.format(new Date());
        //获取目标类
        String targetClassName = joinPoint.getTarget().getClass().getName();
        //获取目标方法
        String targetMethodName = joinPoint.getSignature().getName();
        System.out.println("---->" + now + ":" + targetClassName + "." + targetMethodName);

        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println("--->参数 : " + arg);
        }
    }
    @After("execution(* top.xiongmingcai..*.*(..)))")
    public void doAfter(JoinPoint joinPoint) {
        System.out.println("<----MethodAspect.doAfter");
    }
    @AfterReturning(pointcut="execution(* top.xiongmingcai..*.*(..)))", returning = "ret")
    public void doAfterReturning(JoinPoint joinPoint ,Object ret){
        System.out.println("返回后通知 <---" + ret);
    }
    @AfterThrowing(pointcut="execution(* top.xiongmingcai..*.*(..)))", throwing= "th")
    public void doAfterThrowing(JoinPoint joinPoint,Throwable th){
        System.out.println("异常通知 <---" + th);
    }
}
