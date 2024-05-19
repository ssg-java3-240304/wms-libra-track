package com.sh.model.service;


import com.sh.common.MyBatisTemplate;
import com.sh.model.dao.InWarehousingDao;
import com.sh.model.dao.PublisherManagerMapper;
import com.sh.model.entity.MemberDto;
import com.sh.model.entity.PublisherManagerDto;
import org.apache.ibatis.session.SqlSession;

public class PublisherManagerService {

    public void insertPublisherManager(SqlSession sqlSession, int memberId, int publisherId) {
        PublisherManagerMapper publisherManagerMapper = sqlSession.getMapper(PublisherManagerMapper.class);
        PublisherManagerDto publisherManagerDto = new PublisherManagerDto(memberId, publisherId);
    }
}