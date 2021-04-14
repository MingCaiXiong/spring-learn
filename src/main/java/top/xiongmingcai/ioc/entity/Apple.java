package top.xiongmingcai.ioc.entity;

public class Apple {
    String title;
    String color;
    String origin;

    public Apple() {
        System.out.println(" 无参<-- "+this);
    }

    public Apple(String title, String color, String origin) {
        System.out.println(" -->有参"+this);
        this.title = title;
        this.color = color;
        this.origin = origin;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "title='" + title + '\'' +
                ", color='" + color + '\'' +
                ", origin='" + origin + '\'' +
                '}';
    }
}
