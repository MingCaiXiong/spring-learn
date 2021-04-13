package top.xiongmingcai.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import top.xiongmingcai.ioc.entity.Person;

public class Application {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Person boy = context.getBean("boy", Person.class);

        Person girl = context.getBean("girl", Person.class);
        girl.dress();
        boy.dress();

    }


}
