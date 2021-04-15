import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.xiongmingcai.ioc.dao.IUserDao;
import top.xiongmingcai.ioc.service.UserService;

public class SpringApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        context =context;

    }
}
