package com.sh.controller.publisher;

import com.sh.model.dto.publishserDto.Publisher;
import com.sh.model.service.publisherService.PublisherService;

public class PublisherController {
    PublisherService publisherService = new PublisherService();
    public int getPublisherId(String publisherName) {
        return publisherService.getPublisherId(publisherName);
    }

    public void insertPublisher(Publisher publisher) {
       int result =  publisherService.insertPublisher(publisher);
    }
}
