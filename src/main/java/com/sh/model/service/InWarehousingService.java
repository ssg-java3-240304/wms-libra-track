package com.sh.model.service;

import com.sh.model.dao.InWarehousingDao;
import com.sh.model.entity.InWarehousing;
import com.sh.model.entity.Order;
import com.sh.model.entity.Status;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.sh.common.MyBatisTemplate.getSqlSession;
import org.apache.ibatis.session.SqlSession;
public class InWarehousingService {


    public void insertInWarehousing(HashMap<String, Integer> orders, String publisherName) {


        InWarehousing inWarehousing = new InWarehousing();

        inWarehousing.setDate(new Timestamp(System.currentTimeMillis()));
        inWarehousing.setStatus(Status.PENDING);

        int publisherId = publisherService.findPublisherId(publisherName);
        inWarehousing.setPublisherId(publisherId);



        // iterate over orders
        List<Order> orderList = new ArrayList<>();
        for (String ISBN : orders.keySet()) {
            int quantity = orders.get(ISBN);
            // db query to find bookId using ISBN
            int bookId = bookService.findBookIdByPublisherIdAndISBN(publisherId, ISBN);

            Order order = new Order();
            order.setQuantity(quantity);
            order.setBookId(bookId);

            orderList.add(order);

        }
        inWarehousing.setOrderList(orderList);

        SqlSession sqlSession = getSqlSession();
        InWarehousingDao inWarehousingDAO = sqlSession.getMapper(InWarehousingDao.class);

        try {
            int inWarehousingId = inWarehousingDAO.insertInWarehousing(inWarehousing);

            inWarehousingDAO.insertOrders(inWarehousing);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
    }

    public List<InWarehousing> findInWarehousingByStatus(Status status) {
        SqlSession sqlSession = getSqlSession();
        InWarehousingDao inWarehousingDAO = sqlSession.getMapper(InWarehousingDao.class);

        List<InWarehousing>  inWarehousingList = inWarehousingDAO.findInWarehousingByStatus(status);
        sqlSession.close();

        return inWarehousingList;
    }


}