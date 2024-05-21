package com.sh.model.service;

import com.sh.model.dao.InventoryManagerMapper;
import com.sh.model.dao.MemberMapper;
import com.sh.model.entity.InventoryManagerDto;
import com.sh.model.entity.MemberDto;
import org.apache.ibatis.session.SqlSession;

import static com.sh.common.MyBatisTemplate.getSqlSession;

public class InventoryManagerService {


    public InventoryManagerDto findAll(int memberId) {
        try (
                SqlSession sqlSession = getSqlSession()) {
            InventoryManagerMapper inventoryManagerMapper = sqlSession.getMapper(InventoryManagerMapper.class);
            InventoryManagerDto inventoryManagerDto = inventoryManagerMapper.findAll(memberId);
            sqlSession.commit();
            return  inventoryManagerDto;
        } catch (Exception e){
            throw new RuntimeException(e);
        }

        }

    public int updateId (MemberDto memberDto){
        SqlSession sqlSession = getSqlSession();
        MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
        try {
            int result = memberMapper.updateId(memberDto);
            sqlSession.commit();
            return result;
        } catch (Exception e){
            sqlSession.rollback();
            throw new RuntimeException(e);
        }finally {
            sqlSession.close();
        }


    }

    public int updatePassword(MemberDto memberDto) {
        SqlSession sqlSession = getSqlSession();
        MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
        try {
            int result = memberMapper.updatePassword(memberDto);
            sqlSession.commit();
            return result;
        } catch (Exception e){
            sqlSession.rollback();
            throw new RuntimeException(e);
        }finally {
            sqlSession.close();
        }
    }

    public int updatePhoneNumber(MemberDto memberDto) {
        SqlSession sqlSession = getSqlSession();
        MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
        try {
            int result = memberMapper.updatePassword(memberDto);
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

