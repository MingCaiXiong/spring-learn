package top.xiongmingcai.ioc.utils;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Component
public class MySqlite {
    public MySqlite() {
        System.out.println("MySqlite.MySqlite");
    }
}
