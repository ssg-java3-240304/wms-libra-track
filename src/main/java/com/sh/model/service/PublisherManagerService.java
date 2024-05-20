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
    // 출판사 매니저에 추가하기
    public int insertPublisherManager(SqlSession sqlSession, int memberId, int publisherId) {
        PublisherManagerMapper publisherManagerMapper = sqlSession.getMapper(PublisherManagerMapper.class);
        PublisherManagerDto publisherManagerDto = new PublisherManagerDto(memberId, publisherId);

        publisherManagerMapper.insertPublisherManager(publisherManagerDto);
    }


}

        PublisherManagerDto publisherManagerDto = new PublisherManagerDto( memberId, publisherId);
        int result = publisherManagerMapper.insertPublisherManager(publisherManagerDto);

        return result;
    }

    // 출판사 매니저 정보 조회
    public PublisherManagerDto findPublisherManager(String id) {
        try (SqlSession sqlSession = getSqlSession()) {
            PublisherManagerMapper publisherManagerMapper = sqlSession.getMapper(PublisherManagerMapper.class);
            PublisherManagerDto result = publisherManagerMapper.findPublisherManager(id);
            sqlSession.commit();
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

}
//홍지민 작업 끝
