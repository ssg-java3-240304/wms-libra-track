package com.sh;

import com.sh.model.dao.OrderDao;
import com.sh.model.dto.OrderAreaDetailDto;
import com.sh.model.dto.OrderDto;
import com.sh.model.entity.InWarehousing;
import com.sh.model.entity.Status;
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

        for(OrderDto orderDto : result) {
            System.out.println("Order ID = " + orderDto.getOrderId() +
                    " ISBN = " + orderDto.getISBN() + " quantity " + orderDto.getQuantity());
        }

        assertThat(result.size()).isNotZero();


    }

    @Test
    @DisplayName("Order detail Test")
    public void findOrderDetailByOrderId() {

        OrderAreaDetailDto result = orderDao.findOrderAreaDetailByOrderId(1);

        System.out.println("ISBN = " + result.getISBN() + "quantity " + result.getQuantity());
        System.out.println("Inventory Location = " + result.getLocation() +"Order Area = " + result.getAreaName());
        assertThat(result.getISBN()).isNotNull();
    }

    @Test
    @DisplayName("Order ExWarehousing Test")
    public void findOrdersWithExWarehousingId() {

        List<OrderDto> result = orderDao.findOrdersByExWarehousingId(1);

        for(OrderDto orderDto : result) {
            System.out.println("Order ID = " + orderDto.getOrderId() +
                    " ISBN = " + orderDto.getISBN() + " quantity " + orderDto.getQuantity());
        }

        assertThat(result.size()).isNotZero();
    }

}
