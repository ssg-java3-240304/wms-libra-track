package com.sh;

import com.sh.model.dao.InWarehousingDao;
import com.sh.model.entity.InWarehousing;
import com.sh.model.entity.Status;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Timestamp;

import static com.sh.common.MyBatisTemplate.getSqlSession;

public class InWarehousingTest {
    SqlSession sqlSession;
    InWarehousingDao inWarehousingDao;

    @BeforeEach
    void setUp() {
        this.sqlSession = getSqlSession();
        this.inWarehousingDao = this.sqlSession.getMapper(InWarehousingDao.class);
    }

    @AfterEach
    void tearDown() {
        // this.sqlSession.commit(); // 생략해도 SqlSession 해제시 자동커밋된다. (테스트 환경 제외)
        this.sqlSession.rollback();
        this.sqlSession.close();
    }

    @Test
    void insertMenu() {

        InWarehousing inWarehousing = new InWarehousing();

        inWarehousing.setDate(new Timestamp(System.currentTimeMillis()));
        inWarehousing.setStatus(Status.PENDING);
        inWarehousing.setPublisherMangerId(1);

        // when
        int result = inWarehousingDao.insertInWarehousing(inWarehousing);
        // then
        assertThat(result).isEqualTo(1);
        // 등록된 행의 pk컬럼 가져오기
        int menuCode = menuDto.getMenuCode();
        assertThat(menuCode).isNotZero();

        // 등록된 행을 조회해서 컬럼값 비교
        MenuDto menuDto2 = menuMapper.findByMenuCode(menuCode);
        assertThat(menuDto2.getMenuCode()).isEqualTo(menuCode);
        assertThat(menuDto2.getMenuName()).isEqualTo(menuName);
        assertThat(menuDto2.getMenuPrice()).isEqualTo(menuPrice);
        assertThat(menuDto2.getCategoryCode()).isEqualTo(categoryCode);
        assertThat(menuDto2.getOrderableStatus()).isEqualTo(orderableStatus);
    }
}
