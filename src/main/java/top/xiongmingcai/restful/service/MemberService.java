package top.xiongmingcai.restful.service;

import top.xiongmingcai.restful.entity.Evaluation;
import top.xiongmingcai.restful.entity.Member;

/**
 * (Member)表服务接口
 *
 * @author makejava
 * @since 2021-04-23 08:30:47
 */
public interface MemberService {
    Member createMember(String username, String password, String nickName);

    /**
     * @param username 用户名
     * @param password 密码
     * @return 登录对象
     */
    Member checkLogin(String username, String password);

    /**
     * @param memberid
     * @param bookId
     * @param score    评分
     * @param content  短评内容
     * @return
     */
    Evaluation evaluate(Long memberid, Long bookId, Integer score, String content);
}