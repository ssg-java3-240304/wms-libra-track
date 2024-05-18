package com.sh.controller;

import com.sh.model.entity.MemberDto;
import com.sh.model.service.MemberService;

public class MemberController {
    MemberService memberService = new MemberService();

    public void addMember(MemberDto memberDto) {
        int result = memberService.addMember(memberDto);
    }

    public void selectPublisher(){

    }

    public void selectInventoryManager(){

    }
}
