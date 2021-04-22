package top.xiongmingcai.restful.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.xiongmingcai.restful.entity.Test;

public interface TestDao extends BaseMapper<Test> {
     //自定义示例方法
     void  insetSample();
}
