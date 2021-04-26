package top.xiongmingcai.restful.service;

import top.xiongmingcai.restful.entity.MemberReadState;

public interface MemberReadStateService {
    /**
     * @param memberId
     * @param bookId
     * @return 阅读状态对象
     */
    MemberReadState selectMemberReadState(long memberId, Long bookId);

    /**
     * @param memberid
     * @param bookId
     * @param readState 阅读状态
     * @return 阅读状态对象
     */
    MemberReadState updateMermberReadState(Long memberid, Long bookId, Integer readState);
}
