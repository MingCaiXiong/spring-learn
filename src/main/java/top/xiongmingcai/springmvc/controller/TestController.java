package top.xiongmingcai.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

  @GetMapping("/test") // localhost/t
  //  @ResponseBody // 直接向响应输出字符串数据，不跳转界面
  public ModelAndView test() {
    ModelAndView mad = new ModelAndView("/test");
    String hello = "hello Spring Freemarker";
    return mad.addObject("hello", hello);
  }
}
