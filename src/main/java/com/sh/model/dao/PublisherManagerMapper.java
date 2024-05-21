package com.sh.model.dao;

import com.sh.model.entity.MemberDto;
import com.sh.model.entity.PublisherManagerDto;

public interface PublisherManagerMapper {

    PublisherManagerDto findPublisherManager(MemberDto memberDto);

    int updatePublisherManagerInfo(MemberDto memberDto);
}
