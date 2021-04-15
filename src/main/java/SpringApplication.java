import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.xiongmingcai.ioc.Config;


public class SpringApplication {
    public static void main(String[] args) {
        //基于java config 配置IOC容器初始化
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        System.out.println("------------------------------------------------------------------------------------");
        for (String id : context.getBeanDefinitionNames()) {
            System.out.println(id + " : " + context.getBean(id));

        }

//        context.getBean("userService",UserService.class).show();
    }
}
