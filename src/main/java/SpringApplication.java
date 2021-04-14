import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.xiongmingcai.ioc.entity.Order;

public class SpringApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Order order1 = context.getBean("order1", Order.class);
        System.out.println("order1.getTotal() = " + order1.getTotal());

        context.registerShutdownHook();
    }
}
