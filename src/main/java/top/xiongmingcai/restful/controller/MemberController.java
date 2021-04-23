package top.xiongmingcai.restful.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import top.xiongmingcai.restful.entity.Member;
import top.xiongmingcai.restful.exception.BussinessException;
import top.xiongmingcai.restful.service.MemberService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MemberController {
    @Resource
    private MemberService memberService;

    @GetMapping("/register")//register
    public ModelAndView showReigster() {
        return new ModelAndView("/register");
    }

    @PostMapping("/registe")
    @ResponseBody
    public Map registe(String vc, String username, String password, String nickname, HttpServletRequest request) {
        String verifyCode = (String) request.getSession().getAttribute("verifyCode");
        HashMap<String, Object> result = new HashMap<>();
        if (vc == null || !vc.equalsIgnoreCase(verifyCode)) {
            result.put("code", "VC01");
            result.put("msg", "验证码错误");
        } else {
            try {
                memberService.createMember(username, password, nickname);
                result.put("code", "0");
                result.put("msg", "success");
            } catch (BussinessException ex) {
                ex.printStackTrace();
                result.put("code", ex.getCode());
                result.put("msg", ex.getMsg());
            }
        }
        return result;
    }

    @ResponseBody
    @PostMapping("check_login")
    public Map checkLogin(String username, String password, String vc, HttpSession session) {
        String verifyCode = (String) session.getAttribute("verifyCode");
        HashMap<String, Object> result = new HashMap<>();
        if (vc == null || !vc.equalsIgnoreCase(verifyCode)) {
            result.put("code", "VC01");
            result.put("msg", "验证码错误");
        } else {
            try {
                Member member = memberService.checkLogin(username, password);
                session.setAttribute("loginMember", member);
                result.put("code", "0");
                result.put("msg", "success");
            } catch (BussinessException ex) {
                ex.printStackTrace();
                result.put("code", ex.getCode());
                result.put("msg", ex.getMsg());
            }
        }
        return result;
    }
}
