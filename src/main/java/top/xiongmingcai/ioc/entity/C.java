package top.xiongmingcai.ioc.entity;

public class C {
    private B b;

    public C() {
        System.out.println("c");
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }
}
