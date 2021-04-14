package top.xiongmingcai.ioc.entity;

public class Pen {
    //笔的名称（例如：铅笔，钢笔等）
    private String name;
    private Float price;

    public Pen() {
    }

    public Pen(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
