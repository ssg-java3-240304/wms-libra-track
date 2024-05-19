package com.sh.model.dao;

import com.sh.model.entity.MemberDto;
import com.sh.model.entity.PublisherManagerDto;

public interface PublisherManagerMapper {
    int registerPublisherManager(PublisherManagerDto publisherManagerDto);
}
