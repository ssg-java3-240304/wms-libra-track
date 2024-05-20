package com.sh.controller;


import com.sh.model.entity.MemberDto;
import com.sh.model.entity.PublisherManagerDto;
import com.sh.model.service.PublisherManagerService;
import com.sh.view.PublisherManagerView;
import com.sh.view.PublisherResultView;
import org.apache.ibatis.javassist.compiler.ast.Member;

import java.nio.channels.Pipe;

public class PublisherManagerController {
    PublisherManagerService publisherManagerService = new PublisherManagerService();

    public void findPublisherManagerInfo(MemberDto memberDto) {
        PublisherManagerDto publisherManagerDto = publisherManagerService.findPublisherManagerInfo(memberDto);
        PublisherResultView.displayPublisherManager(publisherManagerDto);
    }

    public void updatePublisherManager(MemberDto memberDto) {
        int result  = publisherManagerService.updatePublisherManager(memberDto);

    }
}
