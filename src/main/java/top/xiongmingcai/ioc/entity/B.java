package top.xiongmingcai.ioc.entity;

public class B {
    private A a;
    public B() {
        System.out.println("b");
    }
    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }


}
