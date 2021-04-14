import com.alibaba.fastjson.JSON;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.xiongmingcai.ioc.entity.SchoolBag;

public class SpringApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        SchoolBag bag = context.getBean("bag", SchoolBag.class);
        SchoolBag tow = context.getBean("tow", SchoolBag.class);
        System.out.println(tow);
        System.out.println(bag);
    }
}
