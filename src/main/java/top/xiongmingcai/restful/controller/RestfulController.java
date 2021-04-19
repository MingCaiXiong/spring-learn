package top.xiongmingcai.restful.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/restful", produces = "application/json;charset=utf-8")
public class RestfulController {
  @GetMapping(value = "/request")
  @ResponseBody
  public String doGetRequest() {
    return "{\"message\":\"数据获取成功\"}";
  }

  @PostMapping(value = "/request")
  @ResponseBody
  public String doPostRequest() {
    return "{\"message\":\"数据新增成功\"}";
  }

  @PutMapping(value = "/request")
  @ResponseBody
  public String doPutRequest() {
    return "{\"message\":\"数据更新成功\"}";
  }

  @DeleteMapping(value = "/request")
  @ResponseBody
  public String doDeleteRequest() {
    return "{\"message\":\"数据更新成功\"}";
  }
}
