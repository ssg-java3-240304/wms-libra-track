package com.sh;

import com.sh.model.dao.InWarehousingDao;
import com.sh.model.entity.InWarehousing;
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

        //this.sqlSession.rollback();
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

    @Test
    @DisplayName("InWarehousing with orders Test")
    void insertInWarehousingWithOrders() {

        InWarehousing inWarehousing = new InWarehousing();

        inWarehousing.setDate(new Timestamp(System.currentTimeMillis()));
        inWarehousing.setStatus(Status.PENDING);
        inWarehousing.setPublisherManagerId(1);

        List<Order> orderList = new ArrayList<>();
        for(int i = 1; i < 4; i++) {
            com.sh.model.entity.Order order = new com.sh.model.entity.Order();
            order.setQuantity(i);
            order.setBookId(2);
            orderList.add(order);
        }
        inWarehousing.setOrderList(orderList);

        int result = inWarehousingDao.insertInWarehousing(inWarehousing);
        System.out.println("result = " + result);
        assertThat(result).isEqualTo(1);

        inWarehousingDao.insertOrders(inWarehousing);

        int id = inWarehousing.getInWarehousingId();
        System.out.println("id = " + id);
        assertThat(id).isNotZero();

        List<InWarehousing> inWarehousing1 = inWarehousingDao.findInWarehousingByStatus(Status.PENDING);
        assertThat(inWarehousing1.get(inWarehousing1.size()-1).getInWarehousingId()).isEqualTo(id);
        assertThat(inWarehousing1.get(inWarehousing1.size()-1).getDate()).isEqualTo(inWarehousing.getDate());
    }

    @Test
    @DisplayName("InWarehousing searching Test")
    void findWithPublisherAndStatus() {

        List<InWarehousing> inWarehousing = inWarehousingDao.findInWarehousingByPublisherIdAndStatus(1, Status.PENDING);
        for(InWarehousing in : inWarehousing) {
            System.out.println("id = " + in.getInWarehousingId() + " date = " + in.getDate() +
                    " status = " + in.getStatus() + " publisherManagerId = " + in.getPublisherManagerId());
        }

        assertThat(inWarehousing.size()).isNotZero();

    }

    @Test
    @DisplayName("InWarehousing update status Test")
    void updateStatus() {

        inWarehousingDao.updateInWarehousingStatus(1, 1, Status.COMPLETED);
        List<InWarehousing> inWarehousing = inWarehousingDao.findInWarehousingByPublisherIdAndStatus(1, Status.COMPLETED);
        for(InWarehousing in : inWarehousing) {
            System.out.println("id = " + in.getInWarehousingId() + " date = " + in.getDate() +
                    " status = " + in.getStatus() + " publisherManagerId = " + in.getPublisherManagerId());
        }

        assertThat(inWarehousing.size()).isNotZero();

    }






}
