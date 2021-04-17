package top.xiongmingcai.jdbc.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.xiongmingcai.jdbc.entity.Hotel;

import javax.annotation.Resource;
import java.text.ParseException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class HotelDaoTest {
    @Resource
    private HotelDao hotelDao;

    @Test
    public void findByOrderno() {
        Hotel hotel = hotelDao.findByOrderId(10001);
        System.out.println("byOrderno = " + hotel);
    }


    @Test
    public void modify() throws ParseException {
        Hotel hotel = hotelDao.findByOrderId(10003);

        hotel.setArrivedate("2020-04-30");
        hotel.setLeavedate("2020-05-03");
        hotelDao.modify(hotel);
    }

    @Test
    public void del() {
        int del = hotelDao.del(10005);
        System.out.println("删除几行 => " + del);
    }

    @Test
    public void addOne() {
        Hotel hotel = new Hotel();
        hotel.setOrderno(10005);
        hotel.setCity("北京");
        hotel.setPrice(588f);
        hotel.setHotelname("酒店5");
        hotel.setArrivedate("2015-05-08");
        hotel.setLeavedate("2015-5-11");
        hotelDao.addOne(hotel);
    }
}