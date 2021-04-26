package top.xiongmingcai.restful.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.xiongmingcai.restful.dao.MemberReadStateDao;
import top.xiongmingcai.restful.entity.MemberReadState;
import top.xiongmingcai.restful.service.MemberReadStateService;

import javax.annotation.Resource;

@Service("memberReadStateService")
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class MemberReadStateServiceImpl implements MemberReadStateService {
    @Resource
    private MemberReadStateDao memberReadStateDao;

    /**
     * @param memberId
     * @param bookId
     * @return 阅读状态对象
     */
    @Override
    public MemberReadState selectMemberReadState(long memberId, Long bookId) {
        QueryWrapper<MemberReadState> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("book_id", bookId);
        queryWrapper.eq("member_id", memberId);
        MemberReadState memberReadState = memberReadStateDao.selectOne(queryWrapper);
        return memberReadState;
    }
}
