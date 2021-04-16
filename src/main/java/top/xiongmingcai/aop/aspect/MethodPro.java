package top.xiongmingcai.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class MethodPro {
    public void welcome(ProceedingJoinPoint pjp) throws Throwable {

        System.out.println("欢迎光临小店");
        try {
            pjp.proceed();
            System.out.println("欢迎光临下次小店");
        } catch (Throwable throwable) {
            throw throwable;
        }
    }
}
