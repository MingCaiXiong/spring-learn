package top.xiongmingcai.restful.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import top.xiongmingcai.restful.entity.Evaluation;
import top.xiongmingcai.restful.entity.Member;
import top.xiongmingcai.restful.exception.BussinessException;
import top.xiongmingcai.restful.service.EvaluationService;
import top.xiongmingcai.restful.service.MemberReadStateService;
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
    @Resource
    private MemberReadStateService memberReadStateService;
    @Resource
    private EvaluationService evaluationService;

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
    @PostMapping("/check_login")
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

    @ResponseBody
    @PostMapping("/update_read_state")
    public Map updateReadState(Long memberId, Long bookid, Integer readState) {
        HashMap<String, Object> result = new HashMap<>();
        try {
            memberReadStateService.updateMermberReadState(memberId, bookid, readState);
            result.put("code", "0");
            result.put("msg", "success");
        } catch (BussinessException ex) {
            ex.printStackTrace();
            result.put("code", ex.getCode());
            result.put("msg", ex.getMsg());
        }
        return result;

    }

    @ResponseBody
    @PostMapping("/evaluate")
    public Map updateReadState(Long memberId, Long bookid, Integer score, String content) {
        HashMap<String, Object> result = new HashMap<>();
        try {
            memberService.evaluate(memberId, bookid, score, content);
            result.put("code", "0");
            result.put("msg", "success");
        } catch (BussinessException ex) {
            ex.printStackTrace();
            result.put("code", ex.getCode());
            result.put("msg", ex.getMsg());
        }
        return result;

    }

    @ResponseBody
    @PostMapping("/enjoy")
    public Map enjoy(Long evaluationId) {
        HashMap<String, Object> result = new HashMap<>();
        if (evaluationId == null) {
            result.put("code", "E01");
            result.put("msg", "参数缺省");
        }
        try {
            Evaluation evaluation = evaluationService.enjoy(evaluationId);
            result.put("code", "0");
            result.put("msg", "success");
            result.put("enaluation", evaluation);
        } catch (BussinessException ex) {
            ex.printStackTrace();
            result.put("code", ex.getCode());
            result.put("msg", ex.getMsg());
        }
        return result;

    }

}
