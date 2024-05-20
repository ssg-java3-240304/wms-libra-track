package com.sh.model.service;

import com.sh.controller.PublisherManagerController;
import com.sh.model.dao.MemberMapper;
import com.sh.model.dao.PublisherManagerMapper;
import com.sh.model.entity.MemberDto;
import com.sh.model.entity.PublisherManagerDto;
import org.apache.ibatis.session.SqlSession;

import java.sql.Timestamp;
import java.time.LocalDate;

import static com.sh.common.MyBatisTemplate.getSqlSession;

public class MemberService {

    PublisherManagerService publisherManagerService = new PublisherManagerService();
    InventoryManagerService inventoryManagerService = new InventoryManagerService();
    public int addMember(MemberDto memberDto) {
        try (SqlSession sqlSession = getSqlSession()) {
            MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
            int result = memberMapper.addMember(memberDto);
            publisherManagerService.insertPublisherManager(sqlSession, memberDto.getMemberId(),10000);


            sqlSession.commit();
            return result;
        } catch (Exception e) {
            // 예외 처리
            // 로그 기록 등
            // 롤백 처리
            throw new RuntimeException("Failed to add member", e);
        }
    }

    public int inventoryAddMember(MemberDto memberDto){
        try(SqlSession sqlSession = getSqlSession()) {
            MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
            int result = memberMapper.addMember(memberDto);
            inventoryManagerService.selectInventoryManager(sqlSession, new Timestamp(System.currentTimeMillis()) ,0 ,10, memberDto.getMemberId());
            sqlSession.commit();
            return result;
        } catch (Exception e) {
            throw new RuntimeException("Failed to selectMember", e);

        }
    }
}
