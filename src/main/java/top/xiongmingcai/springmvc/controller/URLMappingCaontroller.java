package top.xiongmingcai.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.xiongmingcai.springmvc.entity.User;

@Controller
// @RequestMapping(produces = "text/plain;charset=UTF-8")
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

  @GetMapping("/checking")
  @ResponseBody
  public String checking(Long token, @RequestParam("pass_word") String pass) {
    Long token1 = token;
    return token1 + ": " + pass;
  }
  // http://localhost:8080/user?token=12323435&password=NewPassword
  @GetMapping("/user")
  @ResponseBody
  public String login(User user) {
    return "  <meta charset=\"UTF-8\"><fieldset><legend>登陆成功</legend>用户名："
        + user.getToken()
        + "<br>密码："
        + user.getPassword()
        + "</fieldset>";
  }
}
