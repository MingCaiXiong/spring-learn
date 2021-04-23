package top.xiongmingcai.restful.service;

import top.xiongmingcai.restful.entity.Evaluation;
import java.util.List;

/**
 * (Evaluation)表服务接口
 *
 * @author makejava
 * @since 2021-04-23 07:57:18
 */
public interface EvaluationService {

    List<Evaluation> queryAllByBookId(Long bookId);

}