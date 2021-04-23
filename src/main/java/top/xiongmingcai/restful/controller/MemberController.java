package top.xiongmingcai.restful.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
    @GetMapping("/register")//register
    public ModelAndView showReigster() {
        return new ModelAndView("/register");
    }
}
