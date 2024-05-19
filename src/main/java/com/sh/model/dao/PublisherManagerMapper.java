package com.sh.model.dao;

import com.sh.model.entity.PublisherManagerDto;

public interface PublisherManagerMapper {
    int insertPublisherManager(PublisherManagerDto memberId);
    PublisherManagerDto findPublisherManager(String id);

}
