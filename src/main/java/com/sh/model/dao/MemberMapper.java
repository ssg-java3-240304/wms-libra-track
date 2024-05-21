package com.sh.model.dao;

import com.sh.model.entity.MemberDto;
import com.sh.model.entity.Role;
import org.apache.ibatis.annotations.Param;

public interface MemberMapper {
    int updateId(MemberDto memberDto);

    int addMember(MemberDto memberDto);

    MemberDto loginCheck(@Param("userName") String userName, @Param("password") String password);

    int updatePassword(MemberDto memberDto);

    int deleteInfo(MemberDto memberDto);

    int updatePhoneNumber(MemberDto memberDto);
}
