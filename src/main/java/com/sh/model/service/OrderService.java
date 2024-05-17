package com.sh.model.service;

import com.sh.model.dao.OrderDao;
import com.sh.model.dto.OrderDto;
import com.sh.model.entity.Order;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.sh.common.MyBatisTemplate.getSqlSession;

public class OrderService {


    public OrderDto findOrderByOrderId(int orderId) {
        SqlSession sqlSession = getSqlSession();
        OrderDao orderDAO = sqlSession.getMapper(OrderDao.class);

        OrderDto order = orderDAO.findOrderByOrderId(orderId);
        sqlSession.close();

        return order;

    }
    public List<OrderDto> findOrderByInWarehousingId(int inWarehousingId) {
        SqlSession sqlSession = getSqlSession();
        OrderDao orderDAO = sqlSession.getMapper(OrderDao.class);

        List<OrderDto> orderList = orderDAO.findOrderByInWarehousingId(inWarehousingId);
        sqlSession.close();

        return orderList;

    }
}
