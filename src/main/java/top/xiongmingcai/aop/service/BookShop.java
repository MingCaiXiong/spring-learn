package top.xiongmingcai.aop.service;

import org.springframework.stereotype.Service;

@Service
public class BookShop {
    public void sellingBooks(){
        System.out.println("卖出了一本<<java>>书。");

    }
}
