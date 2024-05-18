package com.sh.model.service;

import com.sh.model.dao.MemberMapper;
import com.sh.model.entity.MemberDto;
import org.apache.ibatis.session.SqlSession;

import static com.sh.common.MyBatisTemplate.getSqlSession;

public class MemberService {

    public int addMember(MemberDto memberDto) {
        try (SqlSession sqlSession = getSqlSession()) {
            MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
            int result = memberMapper.addMember(memberDto);
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
