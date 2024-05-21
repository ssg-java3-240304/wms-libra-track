package com.sh.controller;


import com.sh.model.entity.MemberDto;
import com.sh.model.entity.PublisherManagerDto;
import com.sh.model.service.PublisherManagerService;
import com.sh.view.PublisherManagerView;
import org.apache.ibatis.javassist.compiler.ast.Member;

import java.nio.channels.Pipe;

public class PublisherManagerController {
    PublisherManagerService publisherManagerService = new PublisherManagerService();

    public PublisherManagerDto findPublisherManagerInfo(int memberId) {
        PublisherManagerDto publisherManagerDto = publisherManagerService.findPublisherManagerInfo(memberId);
        PublisherManagerView.displayPublisherManager(publisherManagerDto);
        return publisherManagerDto;
    }

    public PublisherManagerDto updatePublisherManager(int memberId) {
        PublisherManagerDto publisherManagerDto = publisherManagerService.updatePublisherManager(memberId);
        PublisherManagerView.displayPublisherManager(publisherManagerDto);
        return publisherManagerDto;
    }
}
