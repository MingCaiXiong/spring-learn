import com.alibaba.fastjson.JSON;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.xiongmingcai.ioc.entity.Pen;
import top.xiongmingcai.ioc.entity.SchoolBag;

public class SpringApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Pen mao1 = context.getBean("mao", Pen.class);
        Pen mao2 = context.getBean("mao", Pen.class);
        Pen mao3 = context.getBean("mao", Pen.class);

    }
}
