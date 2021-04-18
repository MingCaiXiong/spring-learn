package top.xiongmingcai.springmvc.entity;

import java.util.List;

public class Form {

  private String name;
  private String coures;
  private List<Integer> purpose;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCoures() {
    return coures;
  }

  public void setCoures(String coures) {
    this.coures = coures;
  }

  public List<Integer> getPurpose() {
    return purpose;
  }

  public void setPurpose(List<Integer> purpose) {
    this.purpose = purpose;
  }
}
