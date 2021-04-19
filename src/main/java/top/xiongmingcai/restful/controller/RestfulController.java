package top.xiongmingcai.restful.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/restful", produces = "application/json;charset=utf-8")
public class RestfulController {
  @GetMapping(value = "/request")
  public String doGetRequest() {
    return "{\"message\":\"数据获取成功\"}";
  }

  @PostMapping(value = "/request/{rid}")
  public String doPostRequest(@PathVariable("rid") Integer requestId) {
    return "{\"message\":\"数据" + requestId + "新增成功\"}";
  }

  @PutMapping(value = "/request")
  public String doPutRequest() {
    return "{\"message\":\"数据更新成功\"}";
  }

  @DeleteMapping(value = "/request")
  public String doDeleteRequest() {
    return "{\"message\":\"数据更新成功\"}";
  }
}
