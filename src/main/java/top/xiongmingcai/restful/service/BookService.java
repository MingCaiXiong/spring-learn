package top.xiongmingcai.restful.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import top.xiongmingcai.restful.entity.Book;
import java.util.List;

/**
 * (Book)表服务接口
 *
 * @author makejava
 * @since 2021-04-22 13:34:34
 */
public interface BookService {
    public IPage<Book> paging(Integer page , Integer rows);

}