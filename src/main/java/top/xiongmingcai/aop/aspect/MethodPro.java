package top.xiongmingcai.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MethodPro {
    @Around("execution( public * top.xiongmingcai..*.*(..))")
    public Object welcome(ProceedingJoinPoint pjp) throws Throwable {

        Object result;
        System.out.println("欢迎光临小店");
        try {
            result = pjp.proceed();
            System.out.println("欢迎光临下次小店");
        } catch (Throwable throwable) {
            throw throwable;
        }
        return result;
    }
}
