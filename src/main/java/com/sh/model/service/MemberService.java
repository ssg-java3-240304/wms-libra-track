package com.sh.model.service;

import com.sh.model.dao.MemberMapper;
import com.sh.model.dao.PublisherManagerMapper;
import com.sh.model.entity.PublisherManagerDto;
import com.sh.view.InventoryManagerView;
import com.sh.model.entity.MemberDto;
import com.sh.model.entity.Role;
import com.sh.view.PublisherManagerView;
import org.apache.ibatis.session.SqlSession;

import static com.sh.common.MyBatisTemplate.getSqlSession;

public class MemberService {

    PublisherManagerService publisherManagerService = new PublisherManagerService();
    PublisherManagerView publisherManagerView = new PublisherManagerView();
    InventoryManagerView inventoryManagerView = new InventoryManagerView();

    public int insertPublisherMember(MemberDto memberDto) {
        try (SqlSession sqlSession = getSqlSession()) {
            MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
            int result1 = memberMapper.addMember(memberDto);

            //🆘🆘🆘publisherId 스캐너로 입력받기!!🆘🆘🆘
            PublisherManagerMapper publisherManagerMapper = sqlSession.getMapper(PublisherManagerMapper.class);
            PublisherManagerDto publisherManagerDto = new PublisherManagerDto(memberDto.getMemberId(),10000);
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


    public MemberDto loginCheck(String id, String password) {
        try (SqlSession sqlSession = getSqlSession()){
            MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
            MemberDto memberChoice = memberMapper.loginCheck(id, password);
            if(memberChoice.getRole() == Role.PUBLISHER) {
                publisherManagerView.choicePublisherMenu(memberChoice.getUserName());
            }
            return memberChoice;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
