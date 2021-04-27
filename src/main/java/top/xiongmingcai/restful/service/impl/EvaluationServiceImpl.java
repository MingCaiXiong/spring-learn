package top.xiongmingcai.restful.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.xiongmingcai.restful.dao.BookDao;
import top.xiongmingcai.restful.dao.EvaluationDao;
import top.xiongmingcai.restful.dao.MemberDao;
import top.xiongmingcai.restful.entity.Book;
import top.xiongmingcai.restful.entity.Evaluation;
import top.xiongmingcai.restful.entity.Member;
import top.xiongmingcai.restful.service.EvaluationService;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Evaluation)表服务实现类
 *
 * @author makejava
 * @since 2021-04-23 07:57:18
 */
@Service("evaluationService")
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class EvaluationServiceImpl implements EvaluationService {
    @Resource
    private EvaluationDao evaluationDao;
    @Resource
    private MemberDao memberDao;
    @Resource
    private BookDao bookDao;

    @Override
    public List<Evaluation> queryAllByBookId(Long bookId) {
        QueryWrapper<Evaluation> queryWrapper = new QueryWrapper<>();
        Book book = bookDao.selectById(bookId);

        queryWrapper.eq("book_id", bookId);
        queryWrapper.eq("state", "enable");
        queryWrapper.orderByDesc("create_time");

        List<Evaluation> evaluations = evaluationDao.selectList(queryWrapper);

        for (Evaluation evaluation : evaluations) {
            Member member = memberDao.selectById(evaluation.getMemberId());
            evaluation.setMember(member);
            evaluation.setBook(book);
        }
        return evaluations;
    }

    @Override
    public Evaluation enjoy(Long evaluationId) {

        Evaluation evaluation = evaluationDao.selectById(evaluationId);
        evaluation.setEnjoy(evaluation.getEnjoy() + 1);
        evaluationDao.updateById(evaluation);
        return evaluation;
    }

    @Override
    public IPage<Evaluation> paging(Integer page, Integer rows) {

        IPage<Evaluation> page1 = new Page<>(page, rows);

        IPage<Evaluation> evaluationIPage = evaluationDao.selectPage(page1, new QueryWrapper<>());
        List<Evaluation> evaluationList = evaluationIPage.getRecords();
        for (Evaluation evaluation : evaluationList) {
            Book book = bookDao.selectById(evaluation.getBookId());
            Member member = memberDao.selectById(evaluation.getMemberId());

            evaluation.setBook(book);
            evaluation.setMember(member);
        }

        return evaluationIPage;
    }
}