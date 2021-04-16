package top.xiongmingcai.aop.aspect;


import org.aspectj.lang.JoinPoint;

import java.text.SimpleDateFormat;
import java.util.Date;

//切面类
public class MethodAspect {
    //切面方法,用于扩展额外功能
    //JoinPoint 连接点 通过连接点可以获取目标类/方法的信息
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
    public void doAfter(JoinPoint joinPoint) {
        System.out.println("<----MethodAspect.doAfter");
    }
    public void doAfterReturning(JoinPoint joinPoint ,Object ret){
        System.out.println("返回后通知 <---" + ret);
    }
    public void doAfterThrowing(JoinPoint joinPoint,Throwable th){
        System.out.println("异常通知 <---" + th);
    }
}
