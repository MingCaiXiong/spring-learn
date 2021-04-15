package top.xiongmingcai.ioc.entity;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2021-04-15 08:36:52
 */
public class User implements Serializable {
    private static final long serialVersionUID = -66532569268166167L;
    
    private Integer id;
    
    private String user;
    
    private String sex;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

}