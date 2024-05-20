package com.sh.controller;


import com.sh.model.entity.MemberDto;
import com.sh.model.entity.PublisherManagerDto;
import com.sh.model.service.PublisherManagerService;
import org.apache.ibatis.javassist.compiler.ast.Member;

public class PublisherManagerController {
    PublisherManagerService publisherManagerService = new PublisherManagerService();

    public PublisherManagerDto findPublisherManager(String id) {
        return publisherManagerService.findPublisherManager(id);
    }

    public MemberDto findPublisherManagerInfo(int memberId) {
        MemberDto memberDto = publisherManagerService.findPublisherManagerInfo(memberId);

        return memberDto;
    }
}
