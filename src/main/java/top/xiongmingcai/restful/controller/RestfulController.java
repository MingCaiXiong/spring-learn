package top.xiongmingcai.restful.controller;

import org.springframework.web.bind.annotation.*;
import top.xiongmingcai.restful.entity.Person;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/restful")
public class RestfulController {
  @CrossOrigin
  @GetMapping(value = "/request")
  public String doGetRequest() {
    return "{\"message\":\"数据获取成功\"}";
  }
  @CrossOrigin(origins = {"http://127.0.0.1:8080"})
  @PostMapping(value = "/request/{rid}")
  public String doPostRequest(@PathVariable("rid") Integer requestId, Person person) {
    System.out.println(person.getName() + ": " + person.getAge());
    return "{\"message\":\"数据" + requestId + person.getName() + person.getAge() + "新增成功\"}";
  }
  @CrossOrigin(origins = {"http://127.0.0.1:8080"},maxAge = 3600)
  @PutMapping(value = "/request")
  public String doPutRequest(Person person) {
    System.out.println(person.getName() + ": " + person.getAge());
    return "{\"message\":\"数据更新成功\"}";
  }
  @CrossOrigin(origins = {"http://127.0.0.1:8080"},maxAge = 3600)
  @DeleteMapping(value = "/request")
  public String doDeleteRequest() {
    return "{\"message\":\"数据更新成功\"}";
  }

  @GetMapping(value = "/person")
  public Person findByPersonId() {
    // 造数据
    Person person = new Person();
    person.setName("萧炎");
    person.setAge(40);
    person.setDate(new Date());
    return person;
  }
  @GetMapping(value = "/persons")
  public List<Person> findPersons() {
    ArrayList<Person> people = new ArrayList<>();
    // 造数据
    Person p1 = new Person();
    p1.setName("萧炎");
    p1.setAge(40);
    p1.setDate(new Date());


    Person p2 = new Person();
    p2.setName("路飞");
    p2.setDate(new Date());

    people.add(p1);
    people.add(p2);

    return people;
  }
}
