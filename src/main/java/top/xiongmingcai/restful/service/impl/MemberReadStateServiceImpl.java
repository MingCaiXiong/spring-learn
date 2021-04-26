package top.xiongmingcai.restful.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.xiongmingcai.restful.dao.MemberReadStateDao;
import top.xiongmingcai.restful.entity.MemberReadState;
import top.xiongmingcai.restful.service.MemberReadStateService;

import javax.annotation.Resource;
import java.util.Date;

@Service("memberReadStateService")
@Transactional
public class MemberReadStateServiceImpl implements MemberReadStateService {
    @Resource
    private MemberReadStateDao memberReadStateDao;

    /**
     * @param memberId
     * @param bookId
     * @return 阅读状态对象
     */
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public MemberReadState selectMemberReadState(long memberId, Long bookId) {
        QueryWrapper<MemberReadState> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("book_id", bookId);
        queryWrapper.eq("member_id", memberId);
        MemberReadState memberReadState = memberReadStateDao.selectOne(queryWrapper);
        return memberReadState;
    }

    /**
     * @param memberId
     * @param bookId
     * @param readState 阅读状态
     * @return 阅读状态对象
     */
    @Override
    public MemberReadState updateMermberReadState(Long memberId, Long bookId, Integer readState) {
        QueryWrapper<MemberReadState> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("book_id", bookId);
        queryWrapper.eq("member_id", memberId);
        MemberReadState memberReadState = memberReadStateDao.selectOne(queryWrapper);
        //有则更新, 无则新增
        if (memberReadState == null) {
            memberReadState = new MemberReadState();
            memberReadState.setMemberId(memberId);
            memberReadState.setBookId(bookId);
            memberReadState.setReadState(readState);
            memberReadState.setCreateTime(new Date());
            memberReadStateDao.insert(memberReadState);
        } else {
            memberReadState.setReadState(readState);
            memberReadStateDao.updateById(memberReadState);
        }
        return memberReadState;
    }
}
