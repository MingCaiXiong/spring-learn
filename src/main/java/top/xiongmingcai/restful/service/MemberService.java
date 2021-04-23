package top.xiongmingcai.restful.service;

import top.xiongmingcai.restful.entity.Member;

/**
 * (Member)表服务接口
 *
 * @author makejava
 * @since 2021-04-23 08:30:47
 */
public interface MemberService {
    Member createMember(String username, String password, String nickName);

}