package com.sh.model.dao;

import com.sh.model.entity.PublisherManagerDto;

public interface PublisherManagerMapper {
    int insertPublisherManager(PublisherManagerDto publisherManagerDto);

    PublisherManagerDto findPmInfo(int memberId);

    PublisherManagerDto updatePmInfo(int memberId);
}
