package top.xiongmingcai.restful.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import top.xiongmingcai.restful.entity.Book;


/**
 * (Book)表服务接口
 *
 * @author makejava
 * @since 2021-04-22 13:34:34
 */
public interface BookService {
    public IPage<Book> paging(Integer page, Integer rows);

    public IPage<Book> paging(Long categoryId, String order, Integer page, Integer rows);

    Book selectById(Long bookId);

    /**
     * 更新图书评分和评价数量
     */
    void updateEvaluationScoreAndQuantity();

    Book createBook(Book book);

    Book updateBook(Book book);
}