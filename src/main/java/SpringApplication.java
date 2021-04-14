import entity.Apple;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        Apple apple3 = context.getBean("apple3", Apple.class);
        System.out.println(apple3.getTitle());
        //output
        //基于静态工厂
        // 通过无参构建方法构建对象
    }
}
