package factory;

import entity.Apple;

/**
 *
 */
public class AppleFactoryInstance {
    public Apple createSweetApple(){
        System.out.println("基于静态工厂");
        //我们可以才创建对象中赋予额外行为
        Apple apple = new Apple();
        apple.setTitle("红富士");
        apple.setColor("红色");
        apple.setOrigin("美国");
        return apple;
    }
}
