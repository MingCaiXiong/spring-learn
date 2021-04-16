package top.xiongmingcai.aop;


import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.xiongmingcai.aop.service.UserService;

public class SpringApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.createUser();
        userService.validationPassword("MD5" , 16);
    }
}
