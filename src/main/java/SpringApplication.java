import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        String[] beanDefinitionNames = context.getBeanDefinitionNames();

        for (String id : beanDefinitionNames) {
            System.out.println(id + " : "+ context.getBean(id) );
        }
    }
}
