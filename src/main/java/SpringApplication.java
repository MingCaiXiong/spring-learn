import com.alibaba.fastjson.JSON;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.xiongmingcai.ioc.entity.Company;

public class SpringApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Company company = context.getBean("company", Company.class);
        String website = company.getInfo().getProperty("website");
        String jsonString = JSON.toJSONString(company);

        System.out.println("website = " + website);
        System.out.println(jsonString);
/*
        {
            "calculatorMap": {
            "dev-8850": {
                "brand": "联想机",
                        "price": 3085.0,
                        "sn": "234234",
                        "type": "台式机"
            },
            "dev-8848": {
                "brand": "联想机",
                        "price": 3085.0,
                        "sn": "234234",
                        "type": "台式机"
            }
        },
            "info": {
            "phone": "010-12348848",
                    "address": "长沙市芙蓉区",
                    "website": "www.xiongmingcai.top"
        },
            "rooms": ["2001-总裁办", "2002-总经理办公室", "2010-研发部会议室"]
        }*/
    }
}
