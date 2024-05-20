package com.sh.model.service;

import com.sh.model.dao.InventoryManagerMapper;
import com.sh.model.dao.MemberMapper;
import com.sh.model.dao.PublisherManagerMapper;
import com.sh.model.entity.InventoryManagerDto;
import com.sh.model.entity.PublisherManagerDto;
import com.sh.model.entity.MemberDto;
import org.apache.ibatis.session.SqlSession;

import java.sql.Timestamp;

import static com.sh.common.MyBatisTemplate.getSqlSession;

public class MemberService {

    InventoryManagerService inventoryManagerService = new InventoryManagerService();

    public int insertPublisherMember(MemberDto memberDto) {
        try (SqlSession sqlSession = getSqlSession()) {
            MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
            int result1 = memberMapper.addMember(memberDto);

            //🆘🆘🆘publisherId 스캐너로 입력받기!!🆘🆘🆘
            PublisherManagerMapper publisherManagerMapper = sqlSession.getMapper(PublisherManagerMapper.class);
            PublisherManagerDto publisherManagerDto = new PublisherManagerDto(memberDto.getMemberId(), 10000);
            int result2 = publisherManagerMapper.insertPublisherManager(publisherManagerDto);
            sqlSession.commit();
            return result1;
        } catch (Exception e) {
            // 예외 처리
            // 로그 기록 등
            // 롤백 처리
            throw new RuntimeException("Failed to add member", e);
        }
    }

    public int insertInventoryMember(MemberDto memberDto) {
        try (SqlSession sqlSession = getSqlSession()) {
            MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
            int result = memberMapper.addMember(memberDto);

            InventoryManagerMapper inventoryManagerMapper = sqlSession.getMapper(InventoryManagerMapper.class);
            InventoryManagerDto inventoryManagerDto = new InventoryManagerDto(new Timestamp(System.currentTimeMillis()), 0, 10, memberDto.getMemberId());
            int result2 = inventoryManagerMapper.insertInventoryManager(inventoryManagerDto);
            sqlSession.commit();
            return result;
        } catch (Exception e) {
            throw new RuntimeException("Failed to selectMember", e);

        }
    }
}