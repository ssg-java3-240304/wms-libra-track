package com.sh;

import com.sh.model.dao.ExWarehousingDao;
import com.sh.model.entity.ExWarehousing;
import com.sh.model.entity.Order;
import com.sh.model.entity.Status;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static com.sh.common.MyBatisTemplate.getSqlSession;
import static org.assertj.core.api.Assertions.assertThat;

public class ExWarehousingTest {
    SqlSession sqlSession;
    ExWarehousingDao exWarehousingDao;

    @BeforeEach
    void setUp() {
        this.sqlSession = getSqlSession();
        this.exWarehousingDao = this.sqlSession.getMapper(ExWarehousingDao.class);
    }

    @AfterEach
    void tearDown() {

        //this.sqlSession.rollback();
        this.sqlSession.close();
    }
    @DisplayName("Find Exwarehousing by status test")
    @Test
    void findExWarehousingByStatus() {
        List<ExWarehousing> exWarehousing = exWarehousingDao.findExWarehousingByStatus(Status.COMPLETED);

        for (ExWarehousing ex : exWarehousing) {
            System.out.println(" status = " + ex.getStatus() + " address = " + ex.getAddress()
                                + " date = " + ex.getDate() + " receiver = " + ex.getReceiver()
                                + " receiverEmail " + ex.getReceiverEmail());
        }

        assertThat(exWarehousing.size()).isNotZero();
    }
    @DisplayName("update status")
    @Test
    void updateExwarehousingStatus() {
        exWarehousingDao.updateExWarehousingStatus(1,1, Status.PENDING);
        List<ExWarehousing> exWarehousing = exWarehousingDao.findExWarehousingByStatus(Status.PENDING);
        for (ExWarehousing ex : exWarehousing) {
            System.out.println(" status = " + ex.getStatus() + " address = " + ex.getAddress()
                    + " date = " + ex.getDate() + " receiver = " + ex.getReceiver()
                    + " receiverEmail " + ex.getReceiverEmail());
        }
        assertThat(exWarehousing.size()).isNotZero();
    }
}
