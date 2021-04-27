package top.xiongmingcai.restful.controller.admin;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import top.xiongmingcai.restful.entity.Evaluation;
import top.xiongmingcai.restful.service.EvaluationService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/management/evaluation")
public class MComtemController {
    @Resource
    private EvaluationService evaluationService;

    @GetMapping("/")
    public ModelAndView showBook() {
        return new ModelAndView("/admin/comtems");
    }


    @GetMapping("/list")
    @ResponseBody
    public Map showBook(@RequestParam(required = false, defaultValue = "1") Integer page,
                        @RequestParam(required = false, defaultValue = "3") Integer limit) {
        Map<String, Object> result = new HashMap<>();
        IPage<Evaluation> paging = evaluationService.paging(page, limit);
        result.put("code", "0");
        result.put("msg", "success");
        result.put("data", paging.getRecords());
        result.put("count", paging.getTotal());
        return result;
    }
}
