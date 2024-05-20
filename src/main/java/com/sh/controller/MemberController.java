package com.sh.controller;

import com.sh.model.entity.MemberDto;
import com.sh.model.entity.Role;
import com.sh.model.service.MemberService;

public class MemberController {
    MemberService memberService = new MemberService();

    public MemberDto insertPublisherMember(MemberDto memberDto) {
        memberService.insertPublisherMember(memberDto);
        return memberDto;
    }


    public MemberDto loginCheck(String id, String password) {
        return memberService.loginCheck(id, password);
    }
}
