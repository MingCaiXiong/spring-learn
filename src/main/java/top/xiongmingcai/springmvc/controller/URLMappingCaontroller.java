package top.xiongmingcai.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import top.xiongmingcai.springmvc.entity.User;

import java.util.Date;

@Controller
// @RequestMapping(produces = "text/html; charset=UTF-8")
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
  // http://localhost:8080/checking?token=12323435&pass_word=NewPassword&ctime=2020-03-09
  @GetMapping("/checking")
  @ResponseBody
  public String checking(Long token, @RequestParam("pass_word") String pass, Date ctime) {
    Long token1 = token;
    return token1 + ": " + pass + ": " + ctime;
  }
  // http://localhost:8080/user?token=12323435&password=NewPassword
  @GetMapping(value = "/user")
  @ResponseBody
  public String login(User user) {
    return "  <meta charset=\"UTF-8\"><fieldset><legend>登陆成功</legend>用户名："
        + user.getToken()
        + "<br>密码："
        + user.getPassword()
        + "</fieldset>";
  }

  @GetMapping("/view")
  public ModelAndView showView(Integer userid) {
    //    ModelAndView mav = new ModelAndView("/view.jsp");
    ModelAndView mav = new ModelAndView();
    mav.setViewName("redirect:/view.jsp");

    User user = new User();
    if (userid == 1) {
      user.setPassword("lily");
    } else if (userid == 2) {
      user.setPassword("andi");
    }
    mav.addObject("u", user);
    return mav;
  }
  //  http://localhost:8080/view2?userid=1
  @GetMapping("/view2")
  public String showView1(Integer userid, ModelMap modelMap) {
    String view = "/view.jsp";

    User user = new User();
    if (userid == 1) {
      user.setPassword("lily");
    } else if (userid == 2) {
      user.setPassword("andi");
    }
    modelMap.addAttribute("u", user);
    return view;
  }
}
