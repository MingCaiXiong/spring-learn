package top.xiongmingcai.restful.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.xiongmingcai.restful.dao.BookDao;
import top.xiongmingcai.restful.entity.Book;
import top.xiongmingcai.restful.service.BookService;

import javax.annotation.Resource;

@Service("BookService")
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class BookServiceImpl implements BookService {
    @Resource
    private BookDao bookDao;

    @Override
    public IPage<Book> paging(Integer page, Integer rows) {

        IPage<Book> page1 = new Page<>(page, rows);

        return bookDao.selectPage(page1, new QueryWrapper<>());
    }
}
