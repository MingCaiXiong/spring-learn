import com.alibaba.fastjson.JSON;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.xiongmingcai.ioc.entity.Pen;
import top.xiongmingcai.ioc.entity.SchoolBag;

public class SpringApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        context.getBean("a1");
        context.getBean("b1");
        context.getBean("c1");
    }
}
