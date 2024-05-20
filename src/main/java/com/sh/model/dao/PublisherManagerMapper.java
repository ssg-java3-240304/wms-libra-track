package com.sh.model.dao;

import com.sh.model.entity.MemberDto;
import com.sh.model.entity.PublisherManagerDto;

public interface PublisherManagerMapper {
    int insertPublisherManager(PublisherManagerDto publisherManagerDto);

    PublisherManagerDto findPublisherManagerInfo(MemberDto memberDto);

    int updatePublisherManagerInfo(MemberDto memberDto);
}
