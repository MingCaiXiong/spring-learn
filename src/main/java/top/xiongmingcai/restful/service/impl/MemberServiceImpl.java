package top.xiongmingcai.restful.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import top.xiongmingcai.restful.dao.EvaluationDao;
import top.xiongmingcai.restful.dao.MemberDao;
import top.xiongmingcai.restful.entity.Evaluation;
import top.xiongmingcai.restful.entity.Member;
import top.xiongmingcai.restful.exception.BussinessException;
import top.xiongmingcai.restful.service.MemberService;
import top.xiongmingcai.restful.utils.MD5Utils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * (Member)表服务实现类
 *
 * @author makejava
 * @since 2021-04-23 08:30:47
 */
@Service("memberService")
@Transactional
public class MemberServiceImpl implements MemberService {
    @Resource
    private MemberDao memberDao;
    @Resource
    private EvaluationDao evaluationDao;

    @Override
    public Member createMember(String username, String password, String nickName) {
        QueryWrapper<Member> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        List<Member> members = memberDao.selectList(queryWrapper);
        if (members.size() > 0) {
            throw new BussinessException("M01", "用户名已存在");
        }
        Member member = new Member();
        member.setUsername(username);
        member.setNickname(nickName);
        int salt = new Random().nextInt(1000) + 1000;
        String md5Digest = MD5Utils.md5Digest(password, salt);
        member.setPassword(md5Digest);
        member.setSalt(salt);
        member.setCreateTime(new Date());
        memberDao.insert(member);
        return member;
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public Member checkLogin(String username, String password) {
        QueryWrapper<Member> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        Member member = memberDao.selectOne(queryWrapper);
        if (member == null) {
            throw new BussinessException("M02", "用户名不存在");
        }
        String md5 = MD5Utils.md5Digest(password, member.getSalt());

        if (!md5.equals(member.getPassword())) {
            throw new BussinessException("M03", "用户名不存在或密码输入错误");
        }
        return member;
    }

    /**
     * 发布新的短评
     *
     * @param memberId
     * @param bookId
     * @param score    评分
     * @param content  短评内容
     * @return
     */
    @Override
    public Evaluation evaluate(Long memberId, Long bookId, Integer score, String content) {
        Evaluation evaluation = new Evaluation();
        evaluation.setMemberId(memberId);
        evaluation.setBookId(bookId);
        evaluation.setScore(score);
        evaluation.setContent(content);
        evaluation.setCreateTime(new Date());
        evaluation.setState("enable");
        evaluation.setEnjoy(0);
        evaluationDao.insert(evaluation);
        return null;
    }


}