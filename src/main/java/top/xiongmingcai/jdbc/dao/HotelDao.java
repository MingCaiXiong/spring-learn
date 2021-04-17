package top.xiongmingcai.jdbc.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import top.xiongmingcai.jdbc.entity.Hotel;


public class HotelDao {
    private JdbcTemplate jdbcTemplate;


    public Hotel findByOrderId(Integer orderno) {
        String sql = "select * from hotel where orderno = ? ";
        return jdbcTemplate.queryForObject(sql, new Object[]{orderno}, new BeanPropertyRowMapper<>(Hotel.class));
    }

    public int addOne(Hotel hotel) {
        return jdbcTemplate.update("INSERT INTO imooc.hotel (orderno, city, price, hotelname, arrivedate, leavedate) VALUES (?, ?, ?, ? ,?, ?);",
                hotel.getOrderno(), hotel.getCity(), hotel.getPrice(), hotel.getHotelname(), hotel.getArrivedate(), hotel.getLeavedate());

    }

    public int modify(Hotel hotel) {
        return jdbcTemplate.update("UPDATE imooc.hotel t SET t.arrivedate = ? , t.leavedate  = ?  WHERE t.orderno = ?",
                hotel.getArrivedate(), hotel.getLeavedate(), hotel.getOrderno());

    }

    public int del(Integer orderno) {
        return jdbcTemplate.update("DELETE FROM imooc.hotel WHERE orderno = ? ;", orderno);

    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }


    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
