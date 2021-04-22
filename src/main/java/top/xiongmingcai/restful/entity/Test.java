package top.xiongmingcai.restful.entity;

import com.baomidou.mybatisplus.annotation.*;


/**
 * (Test)实体类
 *
 * @author makejava
 * @since 2021-04-21 20:37:13
 */
@TableName("test")//说明实体对应那张表
public class Test {
    //说明这个属性对应字段中的主键我,type值为自增
    @TableId(type = IdType.AUTO)
    @TableField("id")//说明属性对应哪个字段
    private Integer id;
    ////如果字段名与属性名相同或者符合驼峰命名转换规则,则TableField可省略
//    @TableField("content")
    private String content;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}