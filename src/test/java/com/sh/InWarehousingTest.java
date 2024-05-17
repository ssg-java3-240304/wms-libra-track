package com.sh;

import com.sh.model.dao.InWarehousingDao;
import com.sh.model.entity.InWarehousing;
import com.sh.model.entity.Status;
import org.apache.ibatis.jdbc.Null;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Timestamp;
import java.util.List;

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

        this.sqlSession.rollback();
        this.sqlSession.close();
    }

    @Test
    @DisplayName("InWarehousing Test")
    void insertInWarehousing() {

        InWarehousing inWarehousing = new InWarehousing();

        inWarehousing.setDate(new Timestamp(System.currentTimeMillis()));
        inWarehousing.setStatus(Status.PENDING);
        inWarehousing.setPublisherManagerId(1);

        int result = inWarehousingDao.insertInWarehousing(inWarehousing);
        System.out.println("result = " + result);

        assertThat(result).isEqualTo(1);

        int id = inWarehousing.getInWarehousingId();
        assertThat(id).isNotZero();

        List<InWarehousing> inWarehousing1 = inWarehousingDao.findInWarehousingByStatus(Status.PENDING);
        assertThat(inWarehousing1.get(0).getInWarehousingId()).isEqualTo(id);
        assertThat(inWarehousing1.get(0).getDate()).isEqualTo(inWarehousing.getDate());
    }
}
