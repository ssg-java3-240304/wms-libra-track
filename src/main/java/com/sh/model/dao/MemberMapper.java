package com.sh.model.dao;

import com.sh.model.entity.MemberDto;
import com.sh.model.entity.Role;

public interface MemberMapper {
    int addMember(MemberDto memberDto);

    MemberDto loginCheck(String id, String password);
}
