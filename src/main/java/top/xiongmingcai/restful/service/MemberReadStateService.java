package top.xiongmingcai.restful.service;

import top.xiongmingcai.restful.entity.MemberReadState;

public interface MemberReadStateService {
    /**
     * @param memberId
     * @param bookId
     * @return 阅读状态对象
     */
    MemberReadState selectMemberReadState(long memberId, Long bookId);
}
