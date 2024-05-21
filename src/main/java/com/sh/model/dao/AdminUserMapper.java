package com.sh.model.dao;

import com.sh.model.entity.MemberDto;

public interface AdminUserMapper {
    MemberDto findAdminUserInfo(MemberDto memberDto);

    int updateAdminUserInfo(MemberDto memberDto);
}
