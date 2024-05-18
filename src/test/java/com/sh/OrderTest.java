package com.sh;

import com.sh.model.dao.OrderDao;
import com.sh.model.dto.OrderDto;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.*;


import java.util.List;

import static com.sh.common.MyBatisTemplate.getSqlSession;
import static org.assertj.core.api.Assertions.assertThat;

public class OrderTest {

    SqlSession sqlSession;
    OrderDao orderDao;

    @BeforeEach
    void setUp() {
        this.sqlSession = getSqlSession();
        this.orderDao = this.sqlSession.getMapper(OrderDao.class);
    }

    @AfterEach
    void tearDown() {

        //this.sqlSession.rollback();
        this.sqlSession.close();
    }


    @Test
    @DisplayName("Order Test")
    public void findOrdersWithInWarehousingId() {

        List<OrderDto> result = orderDao.findOrderByInWarehousingId(1);
        System.out.println("result = " + result);
        assertThat(result.size()).isNotZero();
        assertThat(result.get(0).getAuthor()).isEqualTo("HEEMIN");

    }
}
