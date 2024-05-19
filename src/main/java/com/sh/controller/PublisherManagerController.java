package com.sh.controller;

import com.sh.model.entity.MemberDto;
import com.sh.model.entity.PublisherManagerDto;
import com.sh.model.service.MemberService;
import com.sh.model.service.PublisherManagerService;

public class PublisherManagerController {

    private PublisherManagerService publisherManagerService = new PublisherManagerService();


    public void registerPublisherManager() {
        publisherManagerService.insertPublisherManager();
    }
}
