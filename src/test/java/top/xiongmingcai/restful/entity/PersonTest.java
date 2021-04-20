package top.xiongmingcai.restful.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;

public class PersonTest {

    @Test
    public void test1() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        // 造数据
        Person person = new Person();
        person.setName("Tom");
        person.setAge(40);
        person.setDate(new Date());
        System.out.println("序列化");
        String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(person);
        System.out.println(jsonString);
        System.out.println("反序列化");
        Person deserializedPerson = mapper.readValue(jsonString, Person.class);
        System.out.println(deserializedPerson);
    }
}