package top.xiongmingcai.restful.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Person {
  // 正常case
  @JsonProperty("user_name")
  private String name;
  // 空对象case
  private Integer age;
  // 日期转换case
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
  private Date date;
  // 默认值case
  private int height;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  @Override
  public String toString() {
    return "Person{" +
            "name='" + name + '\'' +
            ", age=" + age +
            ", date=" + date +
            ", height=" + height +
            '}';
  }
}