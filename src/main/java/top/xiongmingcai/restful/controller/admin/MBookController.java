package top.xiongmingcai.restful.controller.admin;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import top.xiongmingcai.restful.entity.Book;
import top.xiongmingcai.restful.exception.BussinessException;
import top.xiongmingcai.restful.service.BookService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/management/book")
public class MBookController {
    @Resource
    private BookService bookService;

    @GetMapping("/")
    public ModelAndView showBook() {
        return new ModelAndView("/admin/book");
    }

    ///management/book/upload
    @PostMapping("/upload")
    @ResponseBody
    public Map uploadImg(@RequestParam("img") MultipartFile file, HttpServletRequest request) throws IOException {
        String uploadPath = request.getServletContext().getResource("/").getPath() + "/upload/";
        String fileName = String.valueOf(UUID.randomUUID());
        String originalFilename = file.getOriginalFilename();
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);

        file.transferTo(new File(uploadPath + fileName + suffix));
        HashMap<Object, Object> result = new HashMap<>();
        result.put("errno", 0);
        result.put("data", new String[]{"/upload/" + fileName + suffix});

        return result;
    }

    @PostMapping("/create")
    @ResponseBody
    public Map createBook(Book book) {
        Map result = new HashMap();

        try {

            Document document = Jsoup.parse(book.getDescription());
            Element img = document.select("img").first();
            String cover = img.attr("src");

            book.setEvaluationQuantity(0);
            book.setEvaluationScore(5f);
            book.setCover(cover);
            bookService.createBook(book);
            result.put("code", 0);
            result.put("msg", "success");

        } catch (BussinessException ex) {
            ex.printStackTrace();
            result.put("code", ex.getCode());
            result.put("msg", ex.getMsg());
        }

        return result;
    }

    @GetMapping("/list")
    @ResponseBody
    public Map list(@RequestParam(required = false, defaultValue = "1") Integer page,
                    @RequestParam(required = false, defaultValue = "10") Integer limit) {

        IPage<Book> paging = bookService.paging(page, limit);
        HashMap<Object, Object> result = new HashMap<>();
        result.put("code", "0");
        result.put("msg", "success");
        result.put("data", paging.getRecords());
        result.put("count", paging.getTotal());
        return result;
    }
}
