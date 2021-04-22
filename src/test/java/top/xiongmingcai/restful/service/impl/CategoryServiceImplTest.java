package top.xiongmingcai.restful.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.xiongmingcai.restful.entity.Category;
import top.xiongmingcai.restful.service.CategoryService;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class CategoryServiceImplTest {
    @Resource
    private CategoryService categoryService;

    @Test
    public void queryById() {

    }

    @Test
    public void queryAllByLimit() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void update() {
    }

    @Test
    public void deleteById() {
    }

    @Test
    public void selectAll() {
        List<Category> selectAll = categoryService.selectAll();
        System.out.println("selectAll = " + selectAll);
    }
}