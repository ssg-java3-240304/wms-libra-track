package com.sh.controller.publisher;

import com.sh.model.dto.publishserDto.Publisher;
import com.sh.model.service.publisherService.PublisherService;
import com.sh.view.publisherView.DisplayPublisherView;

public class PublisherController {
    PublisherService publisherService = new PublisherService();
    public int getPublisherId(String publisherName) {
        return publisherService.getPublisherId(publisherName);
    }

    public void insertPublisher(Publisher publisher) {
       int result =  publisherService.insertPublisher(publisher);
    }

    public void updatePublisher(Publisher publisher) {
       int result =  publisherService.updatePublisher(publisher);
       Publisher updatePublisher = publisherService.findPublisherInformation(publisher.getPublisherId());
       DisplayPublisherView.displayResult("수정",result,updatePublisher);
       //출판사 정보 출력하는 메소드 추가
    }

    public void findPublisherInformation(int publisherId) {
        Publisher publisher = publisherService.findPublisherInformation(publisherId);
        DisplayPublisherView.displayPublisherInformaitn(publisher);
    }

    public void deletePublisher(int id) {
        int result  = publisherService.deletePublisher(id);
    }
}
