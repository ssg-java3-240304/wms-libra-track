package com.sh.model.service;

import com.sh.model.dao.AdminUserMapper;
import com.sh.model.entity.MemberDto;
import org.apache.ibatis.session.SqlSession;

import static com.sh.common.MyBatisTemplate.getSqlSession;

public class AdminUserService {
    //Admin User 정보 조회
    public MemberDto findAdminUserInfo(MemberDto memberDto) {
        SqlSession sqlSession = getSqlSession();
        AdminUserMapper adminUserMapper = sqlSession.getMapper(AdminUserMapper.class);
        try {
            MemberDto adminUser = adminUserMapper.findAdminUserInfo(memberDto);
            sqlSession.commit();
            return adminUser;
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
    }

    public int updateAdminUserInfo(MemberDto memberDto) {
        SqlSession sqlSession = getSqlSession();
        AdminUserMapper adminUserMapper = sqlSession.getMapper(AdminUserMapper.class);
        try {
            int result = adminUserMapper.updateAdminUserInfo(memberDto);
            sqlSession.commit();
            return result;
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
    }


    //Admin User 정보 수정
}




