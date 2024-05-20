package com.sh.model.service;


import com.sh.model.dao.PublisherManagerMapper;
import com.sh.model.entity.PublisherManagerDto;
import org.apache.ibatis.session.SqlSession;

import static com.sh.common.MyBatisTemplate.getSqlSession;

//홍지민 작업 시작
public class PublisherManagerService {
    // 출판사 매니저 정보 조회
    public PublisherManagerDto findPublisherManagerInfo(int memberId) {
        try (SqlSession sqlSession = getSqlSession()) {
            PublisherManagerMapper publisherManagerMapper = sqlSession.getMapper(PublisherManagerMapper.class);
            PublisherManagerDto publisherManagerDto = publisherManagerMapper.findPmInfo(memberId);
            return publisherManagerDto;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 출판사 매니저 정보 수정
    public PublisherManagerDto updatePublisherManager(int memberId) {
        try (SqlSession sqlSession = getSqlSession()) {
            PublisherManagerMapper publisherManagerMapper = sqlSession.getMapper(PublisherManagerMapper.class);
            PublisherManagerDto publisherManagerDto = publisherManagerMapper.updatePmInfo(memberId);
            return publisherManagerDto;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
//홍지민 작업 끝
