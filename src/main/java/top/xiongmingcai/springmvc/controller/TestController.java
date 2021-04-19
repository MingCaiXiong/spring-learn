package top.xiongmingcai.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import top.xiongmingcai.springmvc.entity.Goods;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class TestController {

  @GetMapping("/test") // localhost/t
  //  @ResponseBody // 直接向响应输出字符串数据，不跳转界面
  public ModelAndView test() {
    ModelAndView mad = new ModelAndView("/test");
    String hello = "hello Spring Freemarker";
    return mad.addObject("hello", hello);
  }

  @GetMapping("/goods")
  public ModelAndView goods() {
    List<Goods> goods = new ArrayList<>();

    for (int i = 0; i < 10; i++) {

      goods.add(new Goods(i, "商品" + i, 23f, "商品描述信息", new Date()));
    }
    ModelAndView mad = new ModelAndView("/goods");
    return mad.addObject("goods", goods);
  }
}
