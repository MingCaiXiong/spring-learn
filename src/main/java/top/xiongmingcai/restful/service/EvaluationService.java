package top.xiongmingcai.restful.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
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

    Evaluation enjoy(Long evaluationId);

    IPage<Evaluation> paging(Integer page, Integer rows);
}