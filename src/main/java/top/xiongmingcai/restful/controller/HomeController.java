package top.xiongmingcai.restful.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import top.xiongmingcai.restful.entity.*;
import top.xiongmingcai.restful.service.BookService;
import top.xiongmingcai.restful.service.CategoryService;
import top.xiongmingcai.restful.service.EvaluationService;
import top.xiongmingcai.restful.service.MemberReadStateService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {
    @Resource
    private CategoryService categoryService;
    @Resource
    private BookService bookService;
    @Resource
    private EvaluationService evaluationService;
    @Resource
    private MemberReadStateService memberReadStateService;

    @GetMapping("/")
    public ModelAndView showHome() {
        ModelAndView mav = new ModelAndView("/index");
        List<Category> categoryList = categoryService.selectAll();
        mav.addObject("categoryList", categoryList);
        return mav;
    }

    /**
     * @param categoryId 分类ID 默认全部
     * @param order      排序默认 按热度
     * @param p          第几页
     * @return 分页接口实现类
     */
    @GetMapping("/books")
    @ResponseBody
    public IPage<Book> selectBook(@RequestParam(required = false, defaultValue = "-1") Long categoryId,
                                  @RequestParam(required = false, defaultValue = "quantity") String order,
                                  @RequestParam(required = false, defaultValue = "1") Integer p) {
        return bookService.paging(categoryId, order, p, 10);
    }

    @GetMapping("/book/{id}")
    public ModelAndView showDetail(@PathVariable("id") Long id, HttpSession session) {
        Book book = bookService.selectById(id);
        List<Evaluation> evaluations = evaluationService.queryAllByBookId(id);
        ModelAndView mav = new ModelAndView("/detail");
        Member loginMember = (Member) session.getAttribute("loginMember");

        if (loginMember != null) {
            MemberReadState memberReadState = memberReadStateService.selectMemberReadState(loginMember.getMemberId(), id);
            mav.addObject("memberReadState", memberReadState);
        }
        mav.addObject("book", book);
        mav.addObject("evaluations", evaluations);
        return mav;
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView doGetMapping(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("message", null);
        return new ModelAndView("/login");
    }


    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView doGetLogoutMapping(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("login_user", null);
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