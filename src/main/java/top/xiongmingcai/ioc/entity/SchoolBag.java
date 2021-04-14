package top.xiongmingcai.ioc.entity;

import java.util.List;

public class SchoolBag {
    //颜色

    private String color;

    //铅笔盒
    private List<Pen> pencilCase;

    public SchoolBag() {
        System.out.println("默认构造方法: " + this);
    }

    public SchoolBag(String color, List<Pen> pencilCase) {
        this.color = color;
        this.pencilCase = pencilCase;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<Pen> getPencilCase() {
        return pencilCase;
    }

    public void setPencilCase(List<Pen> pencilCase) {
        this.pencilCase = pencilCase;
    }
}
