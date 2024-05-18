package com.sh.model.service;

import com.sh.model.dao.BookAreaDao;
import com.sh.model.entity.BookArea;
import org.apache.ibatis.session.SqlSession;

import static com.sh.common.MyBatisTemplate.getSqlSession;

public class BookAreaService {

    public int  reserveBookArea( int areaId, int bookId, int quantity, String areaName) {

        SqlSession sqlSession = getSqlSession();
        BookAreaDao bookAreaDao = sqlSession.getMapper(BookAreaDao.class);

        BookArea bookArea = bookAreaDao.findBookAreaByAreaIdAndBookId(areaId, bookId);

        int book_area_id = 0;
        try {
            if (bookArea == null) {
                bookArea = new BookArea();
                bookArea.setAreaId(areaId);
                bookArea.setBookId(bookId);
                bookArea.setQuantity(0);
                bookArea.setReserved(quantity);
                book_area_id = bookAreaDao.insertBookArea(bookArea);
            } else {
                book_area_id = bookArea.getBookAreaId();
                bookArea.setReserved(bookArea.getReserved() + quantity);
                bookAreaDao.updateBookArea(bookArea);
            }
        } catch (Exception e) {
                sqlSession.rollback();
                throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
        return book_area_id;


    }

    public void updateQuantity(int orderId, int quantity) {
        SqlSession sqlSession = getSqlSession();
        BookAreaDao bookAreaDao = sqlSession.getMapper(BookAreaDao.class);
        try {
            BookArea bookArea = bookAreaDao.findBookAreaByAreaIdAndBookId(orderId, orderId);
            bookArea.setQuantity(bookArea.getQuantity() + quantity);
            bookArea.setReserved(bookArea.getReserved() - quantity);
            bookAreaDao.updateBookArea(bookArea);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }


    }
}
