package top.xiongmingcai.restful.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.xiongmingcai.restful.entity.MemberReadState;
import top.xiongmingcai.restful.service.MemberReadStateService;

public interface MemberReadStateDao extends BaseMapper<MemberReadState> {
    MemberReadState selectOne(QueryWrapper<MemberReadStateService> queryWrapper);

}
