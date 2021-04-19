package top.xiongmingcai.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BMIcontroller {
  @PostMapping("/calculate")
  public ModelAndView calculate(Float height, Integer bodyWeight) {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/calculate.jsp");
    height = height / 100;
    float v = bodyWeight / (height * height);
    String result;
    if (v < 19) {
      result = "多吃点，太瘦了！注意加强营养~";
    } else if (v < 25) {
      result = "体重正常，注意保持~";

    } else {
      result = "该减肥了！注意加强锻炼~";
    }

    mav.addObject("result", result);
    return mav;
  }
}
