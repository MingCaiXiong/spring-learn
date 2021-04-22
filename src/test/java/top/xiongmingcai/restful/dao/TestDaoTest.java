package top.xiongmingcai.restful.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.xiongmingcai.restful.entity.Test;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestDaoTest {
    @Resource
    private TestDao testDao;

    @org.junit.Test
    public void insetSample() {
        testDao.insetSample();
    }

    @org.junit.Test
    public void insert() {
        Test test = new Test();
        test.setContent("mybatis plus test");
        int insert = testDao.insert(test);
        System.out.println("更新多少行?" + insert);
    }

    @org.junit.Test
    public void testUpdateById() {
        Test test = testDao.selectById(63);
        test.setContent("mybatis plus test updateById");
        testDao.updateById(test);
    }

    @org.junit.Test
    public void testDeleteById() {
        testDao.deleteById(63);
    }

    @org.junit.Test
    public void name() {
        //查询条件构造器
        QueryWrapper<Test> queryWrapper = new QueryWrapper<>();
        //相等查询方法
//        queryWrapper.eq("id",64);
//        大于查询方法
        queryWrapper.gt("id", 64);
        List<Test> testList = testDao.selectList(queryWrapper);
        System.out.println(testList);
    }
}