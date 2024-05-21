package com.sh.model.service;

import com.sh.model.dao.InWarehousingDao;
import com.sh.model.entity.InWarehousing;
import com.sh.model.entity.Order;
import com.sh.model.entity.Status;
import org.apache.ibatis.session.SqlSession;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.sh.common.MyBatisTemplate.getSqlSession;
public class InWarehousingService {


    public void insertInWarehousing(HashMap<String, Integer> orders, int publisherManagerId) {


        InWarehousing inWarehousing = new InWarehousing();

        inWarehousing.setDate(new Timestamp(System.currentTimeMillis()));
        inWarehousing.setStatus(Status.PENDING);

        inWarehousing.setPublisherManagerId(publisherManagerId);
        
        // iterate over orders
        List<Order> orderList = new ArrayList<>();
        for (String ISBN : orders.keySet()) {
            int quantity = orders.get(ISBN);
            // db query to find bookId using ISBN
            //int bookId = bookService.findBookIdByPublisherIdAndISBN(publisherId, ISBN);
            int bookId = 1;
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


    public void updateInWarehousingStatus(int inWarehousingId, int inventoryMangerId, Status status) {
        SqlSession sqlSession = getSqlSession();
        InWarehousingDao inWarehousingDAO = sqlSession.getMapper(InWarehousingDao.class);

        try {
            inWarehousingDAO.updateInWarehousingStatus(inWarehousingId, inventoryMangerId, status);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
    }

    public int findPublisherIdByInWarehousingId(int inWarehousingId) {
        SqlSession sqlSession = getSqlSession();
        InWarehousingDao inWarehousingDAO = sqlSession.getMapper(InWarehousingDao.class);

        int publisherId = inWarehousingDAO.findPublisherIdByInWarehousingId(inWarehousingId);
        sqlSession.close();

        return publisherId;
    }


    public List<InWarehousing> findInWarehousingByPublisher(int publisherId) {
        SqlSession sqlSession = getSqlSession();
        InWarehousingDao inWarehousingDAO = sqlSession.getMapper(InWarehousingDao.class);

        List<InWarehousing> inWarehousingList = inWarehousingDAO.findInWarehousingByPublisher(publisherId);
        sqlSession.close();

        return inWarehousingList;
    }

    public List<InWarehousing> findInWarehousingByPublisherManagerId(int publisherManagerId) {
        SqlSession sqlSession = getSqlSession();
        InWarehousingDao inWarehousingDAO = sqlSession.getMapper(InWarehousingDao.class);

        List<InWarehousing> inWarehousingList = inWarehousingDAO.findInWarehousingByPublisherManagerId(publisherManagerId);
        sqlSession.close();

        return inWarehousingList;

    }

    public List<InWarehousing> findInWarehousingByPublisherManagerIdAndStatus(int publisherManagerId, Status status) {
        SqlSession sqlSession = getSqlSession();
        InWarehousingDao inWarehousingDAO = sqlSession.getMapper(InWarehousingDao.class);

        List<InWarehousing> inWarehousingList = inWarehousingDAO.findInWarehousingByPublisherManagerIdAndStatus(publisherManagerId, status);
        sqlSession.close();

        return inWarehousingList;
    }

    public List<InWarehousing> findInWarehousingByPublisherIdAndStatus(int publisherId, Status status) {
        SqlSession sqlSession = getSqlSession();
        InWarehousingDao inWarehousingDAO = sqlSession.getMapper(InWarehousingDao.class);

        List<InWarehousing> inWarehousingList = inWarehousingDAO.findInWarehousingByPublisherIdAndStatus(publisherId, status);
        sqlSession.close();

        return inWarehousingList;
    }
}