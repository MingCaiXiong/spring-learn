package top.xiongmingcai.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.xiongmingcai.springmvc.entity.Form;

import java.util.List;
import java.util.Map;

@Controller
public class FormController {
  //  @PostMapping("/apply")
  @ResponseBody
  public String apply(
      @RequestParam(value = "name", defaultValue = "ANON") String name,
      String course,
      Integer[] purpose) {
    System.out.println(name);
    System.out.println(course);
    for (Integer p : purpose) {
      System.out.println(p);
    }
    return "SUCCESS";
  }
  //
  //  @PostMapping("/apply")
  @ResponseBody
  public String apply2(String name, String course, Integer[] purpose) {
    System.out.println(name);
    System.out.println(course);
    for (Integer p : purpose) {
      System.out.println(p);
    }
    return "SUCCESS";
  }

  //    @PostMapping("/apply")
  @ResponseBody
  public String apply4(String name, String course, @RequestParam List<Integer> purpose) {
    System.out.println(name);
    System.out.println(course);
    for (Integer p : purpose) {
      System.out.println(p);
    }
    return "SUCCESS";
  }

  @PostMapping("/apply")
  @ResponseBody
  public String apply5(Form form) {
    System.out.println("form = " + form);
    return "SUCCESS";
  }

  //  @PostMapping("/apply")
  @ResponseBody
  public String apply6(@RequestParam Map form) {
    System.out.println("form = " + form);
    return "SUCCESS";
  }
}
