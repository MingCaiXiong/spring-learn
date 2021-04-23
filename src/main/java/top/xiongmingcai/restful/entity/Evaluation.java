package top.xiongmingcai.restful.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * (Evaluation)实体类
 *
 * @author makejava
 * @since 2021-04-23 07:52:07
 */
@TableName("evaluation")
public class Evaluation implements Serializable {
    private static final long serialVersionUID = 142987063756868852L;
    /**
     * 评价编号
     */
    @TableId(type = IdType.AUTO)
    private Long evaluationId;
    /**
     * 短评内容
     */
    private String content;
    /**
     * 评分-5分制
     */
    private Integer score;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 会员编号
     */
    private Long memberId;
    /**
     * 图书编号
     */
    private Long bookId;
    /**
     * 点赞数量
     */
    private Integer enjoy;
    /**
     * 审核状态 enable-有效 disable-已禁用
     */
    private String state;
    /**
     * 禁用理由
     */
    private String disableReason;
    /**
     * 禁用时间
     */
    private Date disableTime;
    //说明Book 没有对应字段,不会参与sql中evaluation 自动生成
    @TableField(exist = false)
    private Book book;
    @TableField(exist = false)
    private Member member;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getEvaluationId() {
        return evaluationId;
    }

    public void setEvaluationId(Long evaluationId) {
        this.evaluationId = evaluationId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Integer getEnjoy() {
        return enjoy;
    }

    public void setEnjoy(Integer enjoy) {
        this.enjoy = enjoy;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDisableReason() {
        return disableReason;
    }

    public void setDisableReason(String disableReason) {
        this.disableReason = disableReason;
    }

    public Date getDisableTime() {
        return disableTime;
    }

    public void setDisableTime(Date disableTime) {
        this.disableTime = disableTime;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}