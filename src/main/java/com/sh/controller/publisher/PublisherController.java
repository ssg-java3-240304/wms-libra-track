package com.sh.controller.publisher;

import com.sh.model.service.publisherService.PublisherService;

public class PublisherController {
    PublisherService publisherService = new PublisherService();
    public int getPublisherId(String publisherName) {
        return publisherService.getPublisherId(publisherName);
    }
}
