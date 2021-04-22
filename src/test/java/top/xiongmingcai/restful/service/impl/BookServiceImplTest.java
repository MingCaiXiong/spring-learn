package top.xiongmingcai.restful.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.xiongmingcai.restful.entity.Book;
import top.xiongmingcai.restful.service.BookService;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class BookServiceImplTest {
    @Resource
    private BookService bookService;
    @Test
    public void paging() {
        IPage<Book> paging = bookService.paging(2, 10);
        List<Book> records = paging.getRecords();
        for (Book record : records) {
            System.out.println("record = " + record);
        }
        System.out.println("pages = " + paging.getPages());
        System.out.println("getTotal = " + paging.getTotal());
    }
    @Test
    public void paging2() {
        IPage<Book> paging = bookService.paging(1L,"quantity",1, 10);
        List<Book> records = paging.getRecords();
        for (Book record : records) {
            System.out.println("record = " + record);
        }
        System.out.println("pages = " + paging.getPages());
        System.out.println("getTotal = " + paging.getTotal());
    }
}