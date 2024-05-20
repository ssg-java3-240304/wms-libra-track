package com.sh.model.service;


import com.sh.model.dao.PublisherManagerMapper;
import com.sh.model.entity.MemberDto;
import com.sh.model.entity.PublisherManagerDto;
import org.apache.ibatis.session.SqlSession;

import static com.sh.common.MyBatisTemplate.getSqlSession;

//홍지민 작업 시작
public class PublisherManagerService {
    // 출판사 매니저 정보 조회
    public PublisherManagerDto findPublisherManagerInfo(MemberDto memberDto) {
        SqlSession sqlSession = getSqlSession();
        PublisherManagerMapper publisherManagerMapper = sqlSession.getMapper(PublisherManagerMapper.class);
        try {
            PublisherManagerDto publisherManagerDto = publisherManagerMapper.findPublisherManagerInfo(memberDto);
            sqlSession.commit();
            return publisherManagerDto;
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
    }

    // 출판사 매니저 정보 수정
    public int updatePublisherManager(int memberId) {
        SqlSession sqlSession = getSqlSession();
        PublisherManagerMapper publisherManagerMapper = sqlSession.getMapper(PublisherManagerMapper.class);
        try {
            int result = publisherManagerMapper.updatePublisherManagerInfo(memberId);
            sqlSession.commit();
            return result;
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
    }
}
//홍지민 작업 끝
