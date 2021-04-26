package top.xiongmingcai.restful.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.xiongmingcai.restful.entity.Book;

/**
 * (Book)表数据库访问层
 *
 * @author makejava
 * @since 2021-04-22 13:29:44
 */
public interface BookDao extends BaseMapper<Book> {

    /**
     * 更新图书评分和评价数量
     */
    void updateEvaluationScoreAndQuantity();

}