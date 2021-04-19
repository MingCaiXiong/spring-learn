package top.xiongmingcai.restful.controller;

import org.springframework.web.bind.annotation.*;
import top.xiongmingcai.restful.entity.Person;

@RestController
@RequestMapping(value = "/restful", produces = "application/json;charset=utf-8")
public class RestfulController {
  @GetMapping(value = "/request")
  public String doGetRequest() {
    return "{\"message\":\"数据获取成功\"}";
  }

  @PostMapping(value = "/request/{rid}")
  public String doPostRequest(@PathVariable("rid") Integer requestId, Person person) {
    System.out.println(person.getName() + ": " + person.getAge());
    return "{\"message\":\"数据" + requestId + person.getName() + person.getAge() + "新增成功\"}";
  }

  @PutMapping(value = "/request")
  public String doPutRequest(Person person) {
    System.out.println(person.getName() + ": " + person.getAge());
    return "{\"message\":\"数据更新成功\"}";
  }

  @DeleteMapping(value = "/request")
  public String doDeleteRequest() {
    return "{\"message\":\"数据更新成功\"}";
  }
}
