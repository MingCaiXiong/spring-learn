package top.xiongmingcai.ioc.entity;

public class Person {
    private String name;
    private Clothes clothes;

    public Person() {
    }

    public Person(String name, Clothes clothes) {
        this.name = name;
        this.clothes = clothes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Clothes getClothes() {
        return clothes;
    }

    public void setClothes(Clothes clothes) {
        this.clothes = clothes;
    }

    public void dress(){
        System.out.println(name + " 爱穿"+ clothes.getColor() + clothes.getStyle());
    }
}
