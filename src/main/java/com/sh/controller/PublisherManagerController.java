package com.sh.controller;


import com.sh.model.entity.PublisherManagerDto;
import com.sh.model.service.PublisherManagerService;

public class PublisherManagerController {
    PublisherManagerService publisherManagerService = new PublisherManagerService();




    public PublisherManagerDto findPublisherManager() {
        return publisherManagerService.findPublisherManager();
    }
}
