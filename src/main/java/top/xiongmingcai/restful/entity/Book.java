package top.xiongmingcai.restful.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * (Book)实体类
 *
 * @author makejava
 * @since 2021-04-22 13:25:30
 */
@TableName("book")
public class Book implements Serializable {
    private static final long serialVersionUID = -30985235898015943L;
    /**
    * 图书编号
    */
    @TableId(value = "book_id",type = IdType.AUTO)
    private Long bookId;
    /**
    * 书名
    */
    private String bookName;
    /**
    * 子标题
    */
    private String subTitle;
    /**
    * 作者
    */
    private String author;
    /**
    * 封面图片URL
    */
    private String cover;
    /**
    * 图书详情
    */
    private String description;
    /**
    * 分类编号
    */
    private Long categoryId;
    /**
    * 图书评分
    */
    private Float evaluationScore;
    /**
    * 评价数量
    */
    private Integer evaluationQuantity;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Float getEvaluationScore() {
        return evaluationScore;
    }

    public void setEvaluationScore(Float evaluationScore) {
        this.evaluationScore = evaluationScore;
    }

    public Integer getEvaluationQuantity() {
        return evaluationQuantity;
    }

    public void setEvaluationQuantity(Integer evaluationQuantity) {
        this.evaluationQuantity = evaluationQuantity;
    }
}