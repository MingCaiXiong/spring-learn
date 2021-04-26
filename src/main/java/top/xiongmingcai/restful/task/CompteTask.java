package top.xiongmingcai.restful.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import top.xiongmingcai.restful.service.BookService;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class CompteTask {
    @Resource
    private BookService bookService;

    //任务调度
    @Scheduled(cron = "0 * * * * ?")
    public void updaEvaluation() {
        bookService.updateEvaluationScoreAndQuantity();
        System.out.println(" bookService.updateEvaluationScoreAndQuantity" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}
