package top.xiongmingcai.restful.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.xiongmingcai.restful.service.MemberService;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MemberServiceImplTest {
    @Resource
    private MemberService memberService;

    @Test
    public void createMember() {
        memberService.createMember("s123456", "123456", "测试用例");
    }
}