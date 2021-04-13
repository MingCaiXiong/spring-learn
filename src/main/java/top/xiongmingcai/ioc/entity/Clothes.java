package top.xiongmingcai.ioc.entity;

public class Clothes {
    private String style;
    private String color;

    public Clothes() {
    }

    public Clothes(String style, String color) {
        this.style = style;
        this.color = color;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Clothes{" +
                "style='" + style + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
