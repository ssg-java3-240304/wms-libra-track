package com.sh.controller;

import com.sh.model.entity.MemberDto;
import com.sh.model.service.MemberService;

public class MemberController {
    MemberService memberService = new MemberService();

    public MemberDto addMember(MemberDto memberDto) {
        memberService.addMember(memberDto);
        return memberDto;
    }

    public void selectPublisher(){

    }

    public void selectInventoryManager(){

    }
}
