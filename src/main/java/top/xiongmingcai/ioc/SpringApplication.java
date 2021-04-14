package top.xiongmingcai.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.xiongmingcai.ioc.entity.Apple;
import top.xiongmingcai.ioc.entity.Child;

public class SpringApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//        Apple sweeApple = context.getBean("sweetApple", Apple.class);
//        Apple sourApple = context.getBean("sourApple", Apple.class);
//        Apple softApple = context.getBean("softApple", Apple.class);
//        Child lily = context.getBean("lily", Child.class);
        Child andy = context.getBean("andy", Child.class);
//        Child luna = context.getBean("luna", Child.class);
        andy.eat();



    }
}
