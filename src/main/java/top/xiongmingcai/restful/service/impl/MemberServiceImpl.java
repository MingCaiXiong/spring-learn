package top.xiongmingcai.restful.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.xiongmingcai.restful.dao.MemberDao;
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
        return null;
    }
}