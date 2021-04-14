package top.xiongmingcai.ioc.entity;

public class Order {
    private Float price;
    private Integer quantity;
    private Float total;

    public Order() {
        System.out.println("创建"+ this);
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        System.out.println("Order.setPrice");
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        System.out.println("Order.setQuantity");
        this.quantity = quantity;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public void init(){
        System.out.println("Order.init");
        this.total = price * quantity;
    }
    public void  destroy(){
        System.out.println("Order.destroy");
    }
}
