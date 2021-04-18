package top.xiongmingcai.springmvc.entity;

public class User {
  private Long token;
  private String password;

  public Long getToken() {
    return token;
  }

  public void setToken(Long token) {
    this.token = token;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
