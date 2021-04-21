package top.xiongmingcai.restful.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import top.xiongmingcai.restful.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @GetMapping("/index")
    public ModelAndView showHome() {
        ModelAndView mav = new ModelAndView("/index");

        return mav;
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView doGetMapping(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("message",null);
        return new ModelAndView("/login");
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView doPostMapping(HttpServletRequest request, User user) {
        System.out.println(user);
        HttpSession session = request.getSession();
        if (user.getName().equals("admin") && user.getPassword().equals("admin")) {
            ModelAndView mav = new ModelAndView("redirect:/main");
            session.setAttribute("login_user", user.getName());
            mav.addObject("u", user);
            return mav;
        } else {
            session.setAttribute("message","用户名或密码错误,请重新登录!!");
            return new ModelAndView("/login");
        }

    }
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView doGetLogoutMapping(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("login_user",null);
        return new ModelAndView("redirect:/login");
    }


    @GetMapping("/main")
    public ModelAndView showMain() {
        ModelAndView mav = new ModelAndView("/main");

        return mav;
    }

    @ResponseBody
    @GetMapping("/test")
    public String test() {
        return "ping test ok 中文不乱码!";
    }
    @ResponseBody
    @GetMapping("/test2")
    public String test2() {
        return "{\"name\":\"萧炎\",\"work\":\"炼药师\"}";
    }
}