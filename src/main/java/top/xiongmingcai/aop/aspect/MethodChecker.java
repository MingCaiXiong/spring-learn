package top.xiongmingcai.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MethodChecker {
    //ProceedingJoinPoint 是JoinPoint 升级版
    public void check(ProceedingJoinPoint pjp) throws Throwable {
        try {
            long startingTime = new Date().getTime();
            //获得目标函数执行返回值
            Object ret = pjp.proceed();//控制目标方法是否执行
            long endTime = new Date().getTime();

            long duration = endTime - startingTime;
            if (duration >= 1000) {
                String targetClassName = pjp.getTarget().getClass().getName();
                String targetMethodName = pjp.getSignature().getName();

                SimpleDateFormat sdf = new SimpleDateFormat();
                String now = sdf.format(new Date());
                System.out.println("---->" + now + ":" + targetClassName + "." + targetMethodName +"用时:"+duration);
            }
        } catch (Throwable throwable) {
            System.out.println("Exception message = " + throwable.getMessage()); //捕获异常
            throw throwable;
        }
    }
}
