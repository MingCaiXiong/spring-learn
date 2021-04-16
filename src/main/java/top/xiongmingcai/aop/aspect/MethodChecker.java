package top.xiongmingcai.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component //标记当前类为组件
@Aspect //说明点前类是切面类
public class MethodChecker {
    //ProceedingJoinPoint 是JoinPoint 升级版
    @Around("execution( public * top.xiongmingcai..*.*(..)))")
    public Object check(ProceedingJoinPoint pjp) throws Throwable {
        Object ret;
        try {
            long startingTime = new Date().getTime();
            //获得目标函数执行返回值
            //控制目标方法是否执行
            ret = pjp.proceed();
            long endTime = new Date().getTime();

            long duration = endTime - startingTime;
            if (duration >= 1000) {
                String targetClassName = pjp.getTarget().getClass().getName();
                String targetMethodName = pjp.getSignature().getName();

                SimpleDateFormat sdf = new SimpleDateFormat();
                String now = sdf.format(new Date());
                System.out.println("---->" + now + ":" + targetClassName + "." + targetMethodName + "用时:" + duration);
            }
        } catch (Throwable throwable) {
            System.out.println("Exception message = " + throwable.getMessage()); //捕获异常
            throw throwable;
        }
        return ret;
    }
}
