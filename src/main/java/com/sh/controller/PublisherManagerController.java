package com.sh.controller;


import com.sh.model.entity.MemberDto;
import com.sh.model.entity.PublisherManagerDto;
import com.sh.model.service.PublisherManagerService;
import com.sh.view.MemberResultView;

public class PublisherManagerController {
    PublisherManagerService publisherManagerService = new PublisherManagerService();

    public void findPublisherManagerInfo(MemberDto memberDto) {
        PublisherManagerDto publisherManagerDto = publisherManagerService.findPublisherManagerInfo(memberDto);
        MemberResultView.displayPublisherManager(publisherManagerDto);
    }

    public void updatePublisherManager(MemberDto memberDto) {
        int result  = publisherManagerService.updatePublisherManager(memberDto);
    }
}
