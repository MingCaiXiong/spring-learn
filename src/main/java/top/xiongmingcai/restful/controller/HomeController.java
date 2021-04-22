package top.xiongmingcai.restful.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import top.xiongmingcai.restful.entity.Category;
import top.xiongmingcai.restful.entity.User;
import com.baomidou.mybatisplus.core.metadata.IPage;
import top.xiongmingcai.restful.entity.Book;
import top.xiongmingcai.restful.service.BookService;
import top.xiongmingcai.restful.service.CategoryService;

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

    @GetMapping("/")
    public ModelAndView showHome() {
        ModelAndView mav = new ModelAndView("/index");
        List<Category> categoryList = categoryService.selectAll();
        mav.addObject("categoryList", categoryList);
        return mav;
    }

    /**
     * @param categoryId 分类ID 默认全部
     * @param order  排序默认 按热度
     * @param p 第几页
     * @return  分页接口实现类
     */
    @GetMapping("/books")
    @ResponseBody
    public IPage<Book> selectBook(@RequestParam(required = false, defaultValue = "-1") Long categoryId,
                                  @RequestParam(required = false, defaultValue = "quantity") String order,
                                  @RequestParam(required = false, defaultValue = "1") Integer p) {
        return bookService.paging(categoryId, order, p, 10);
    }

    @GetMapping("/book/{id}")
    public ModelAndView showDetail(@PathVariable("id")Long id) {
        Book book = bookService.selectById(id);
        ModelAndView mav = new ModelAndView("/detail");
        mav.addObject("book", book);
        return mav;
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView doGetMapping(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("message", null);
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
            session.setAttribute("message", "用户名或密码错误,请重新登录!!");
            return new ModelAndView("/login");
        }

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