package com.sh.model.dao;

import com.sh.model.entity.MemberDto;
import org.apache.ibatis.annotations.Param;

public interface MemberMapper {
    //홍지민 작업 시작
    int insertMember(MemberDto memberDto);

    MemberDto loginCheck(@Param("userName") String userName, @Param("password") String password);
    // 홍지민 작업 끝
}
