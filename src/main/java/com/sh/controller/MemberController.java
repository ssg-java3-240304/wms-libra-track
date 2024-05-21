package com.sh.controller;

import com.sh.model.entity.MemberDto;
import com.sh.model.entity.Role;
import com.sh.model.service.MemberService;
import com.sh.view.PublisherResultView;

public class MemberController {
    MemberService memberService = new MemberService();

    public int insertPublisherMember(MemberDto memberDto) {
        int result = memberService.insertPublisherMember(memberDto);
        PublisherResultView.displayResult("회원 가입", result);
        return result;
    }

    public MemberDto insertInventoryManager(MemberDto memberDto) {
        memberService.insertInventoryMember(memberDto);
        return memberDto;
    }

    public MemberDto loginCheck(String id, String password) {
        return memberService.loginCheck(id, password);
    }
}
