package com.sh.model.dao;

import com.sh.model.dto.publishserDto.Publisher;

public interface PublisherDAO {
    int getPublisherId(String publisherName);

    int insertPublisher(Publisher publisher);
}
