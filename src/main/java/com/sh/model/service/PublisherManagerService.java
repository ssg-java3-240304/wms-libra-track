package com.sh.model.service;


import com.sh.common.MyBatisTemplate;
import com.sh.model.dao.InWarehousingDao;
import com.sh.model.dao.InventoryManagerMapper;
import com.sh.model.dao.PublisherManagerMapper;
import com.sh.model.entity.InventoryManagerDto;
import com.sh.model.entity.MemberDto;
import com.sh.model.dao.PublisherManagerMapper;
import com.sh.model.entity.PublisherManagerDto;
import org.apache.ibatis.session.SqlSession;

import static com.sh.common.MyBatisTemplate.getSqlSession;

//홍지민 작업 시작
public class PublisherManagerService {
    // 출판사 매니저 정보 조회
    public PublisherManagerDto findPublisherManager(String id) {
        SqlSession sqlSession = getSqlSession();
        PublisherManagerMapper publisherManagerMapper = sqlSession.getMapper(PublisherManagerMapper.class);
        try {
            PublisherManagerDto result = publisherManagerMapper.findPublisherManager(id);
            sqlSession.commit();

            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }


    }

    public MemberDto findPublisherManagerInfo(int memberId) {
        try (SqlSession sqlSession = getSqlSession()) {
            PublisherManagerMapper publisherManagerMapper = sqlSession.getMapper(PublisherManagerMapper.class);
            MemberDto memberDto = publisherManagerMapper.findPublisherManagerInfo(memberId);
            return memberDto;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
//홍지민 작업 끝
