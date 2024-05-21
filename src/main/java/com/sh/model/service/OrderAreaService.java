package com.sh.model.service;

import com.sh.model.dao.OrderAreaDao;
import com.sh.model.entity.OrderArea;
import org.apache.ibatis.session.SqlSession;

import static com.sh.common.MyBatisTemplate.getSqlSession;

public class OrderAreaService {


    public void insertOrderArea(int bookAreaId, int orderId) {

        OrderArea orderArea = new OrderArea();
        orderArea.setBookAreaId(bookAreaId);
        orderArea.setOrderId(orderId);

        SqlSession sqlSession = getSqlSession();
        OrderAreaDao orderAreaDao = sqlSession.getMapper(OrderAreaDao.class);

        try {
            orderAreaDao.insertOrderArea(orderArea);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }


    }

    public OrderArea findOrderAreaByOrderId(int orderId) {
        SqlSession sqlSession = getSqlSession();
        OrderAreaDao orderAreaDao = sqlSession.getMapper(OrderAreaDao.class);
        OrderArea orderArea = orderAreaDao.findOrderAreaByOrderId(orderId);
        sqlSession.close();
        return orderArea;
    }
}
