package com.sh.model.service;

import com.sh.model.dao.MemberMapper;
import com.sh.model.dao.PublisherManagerMapper;
import com.sh.model.entity.MemberDto;
import com.sh.model.entity.PublisherManagerDto;
import org.apache.ibatis.session.SqlSession;

import static com.sh.common.MyBatisTemplate.getSqlSession;

public class MemberService {

    PublisherManagerService publisherManagerService = new PublisherManagerService();
    public int addMember(MemberDto memberDto) {
        try (SqlSession sqlSession = getSqlSession()) {
            MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);

            int result = memberMapper.addMember(memberDto);
//            publisherManagerService.insertPublisherManager(memberDto);
            PublisherManagerMapper publisherManagerMapper = sqlSession.getMapper(PublisherManagerMapper.class);
            PublisherManagerDto publisherManagerDto = new PublisherManagerDto(memberDto.getMemberId(), 10000);
            publisherManagerMapper.registerPublisherManager(publisherManagerDto);
            sqlSession.commit();
            return result;
        } catch (Exception e) {
            // 예외 처리
            // 로그 기록 등
            // 롤백 처리
            throw new RuntimeException("Failed to add member", e);
        }
    }
}
