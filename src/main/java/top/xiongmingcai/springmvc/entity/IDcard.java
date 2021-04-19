package top.xiongmingcai.springmvc.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class IDcard {
  private String name;
  private String idno;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date expire;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getIdno() {
    return idno;
  }

  public void setIdno(String idno) {
    this.idno = idno;
  }

  public Date getExpire() {
    return expire;
  }

  public void setExpire(Date expire) {
    this.expire = expire;
  }
}
