import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");


        Apple one = context.getBean("one",  Apple.class);
        Apple apple2 = context.getBean("apple2",  Apple.class);
        System.out.println(one.getTitle());
        System.out.println(apple2.getTitle());
    }
}
