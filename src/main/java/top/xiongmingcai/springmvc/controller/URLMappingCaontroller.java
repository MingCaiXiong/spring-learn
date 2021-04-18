package top.xiongmingcai.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
// @RequestMapping(value="/g",method = RequestMethod.GET)
public class URLMappingCaontroller {
  @GetMapping("/g")
  @ResponseBody
  public String getMapping() {
    return "this is get 方法";
  }

  @PostMapping("/post")
  @ResponseBody
  public String postMapping(
      @RequestParam("foo") String username, @RequestParam("lorem") String passowrld) {
    return username + "\n" + passowrld;
  }
}
