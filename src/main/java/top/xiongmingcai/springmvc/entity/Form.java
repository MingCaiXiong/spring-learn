package top.xiongmingcai.springmvc.entity;

import java.util.List;

public class Form {

  private String username;
  private String course;
  private List<Integer> purpose;
  private IDcard idcard = new IDcard();

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getCourse() {
    return course;
  }

  public void setCourse(String course) {
    this.course = course;
  }

  public List<Integer> getPurpose() {
    return purpose;
  }

  public void setPurpose(List<Integer> purpose) {
    this.purpose = purpose;
  }

  public IDcard getIdcard() {
    return idcard;
  }

  public void setIdcard(IDcard idcard) {
    this.idcard = idcard;
  }
}
