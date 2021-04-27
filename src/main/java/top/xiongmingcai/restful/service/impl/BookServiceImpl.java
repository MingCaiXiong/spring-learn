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
import top.xiongmingcai.restful.dao.MemberReadStateDao;
import top.xiongmingcai.restful.entity.Book;
import top.xiongmingcai.restful.entity.Evaluation;
import top.xiongmingcai.restful.entity.MemberReadState;
import top.xiongmingcai.restful.service.BookService;

import javax.annotation.Resource;

@Service("BookService")
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class BookServiceImpl implements BookService {
    @Resource
    private BookDao bookDao;
    @Resource
    private MemberDao memberDao;
    @Resource
    private MemberReadStateDao memberReadStateDao;
    @Resource
    private EvaluationDao evaluationDao;

    @Override
    public IPage<Book> paging(Integer page, Integer rows) {

        IPage<Book> page1 = new Page<>(page, rows);

        return bookDao.selectPage(page1, new QueryWrapper<>());
    }

    @Override
    public IPage<Book> paging(Long categoryId, String order, Integer page, Integer rows) {
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        if (categoryId != null && categoryId != -1) {
            queryWrapper.eq("category_id", categoryId);
        }
        if (order != null) {
            if (order.equals("quantity")) {
                queryWrapper.orderByDesc("evaluation_quantity");
            } else if (order.equals("score")) {
                queryWrapper.orderByDesc("evaluation_score");
            }
        }

        IPage<Book> page1 = new Page<>(page, rows);

        return bookDao.selectPage(page1, queryWrapper);
    }

    @Override
    public Book selectById(Long bookId) {
        return bookDao.selectById(bookId);
    }

    /**
     * 更新图书评分和评价数量
     */
    @Override
    @Transactional
    public void updateEvaluationScoreAndQuantity() {
        bookDao.updateEvaluationScoreAndQuantity();
    }

    @Override
    @Transactional
    public Book createBook(Book book) {
        bookDao.insert(book);
        return book;
    }

    @Override
    @Transactional
    public Book updateBook(Book book) {
        bookDao.updateById(book);
        return book;
    }

    @Override
    @Transactional
    public void deleteBook(Long bookId) {
        bookDao.deleteById(bookId);
        deleteMemberReadState(bookId);
        deleteEvaluation(bookId);
    }

    private void deleteMemberReadState(Long bookId) {
        QueryWrapper<MemberReadState> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("book_id", bookId);
        memberReadStateDao.delete(queryWrapper);
    }

    private void deleteEvaluation(Long bookId) {
        QueryWrapper<Evaluation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("book_id", bookId);
        evaluationDao.delete(queryWrapper);
    }
}
