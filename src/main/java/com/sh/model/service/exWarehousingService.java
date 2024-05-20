package com.sh.model.service;

import com.sh.model.dao.ExWarehousingDao;
import com.sh.model.dao.InWarehousingDao;
import com.sh.model.entity.ExWarehousing;
import com.sh.model.entity.InWarehousing;
import com.sh.model.entity.Status;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.sh.common.MyBatisTemplate.getSqlSession;

public class exWarehousingService {
    public void save() {
        // Todo
    }

    public List<ExWarehousing> findExWarehousingByStatus(Status status) {
        SqlSession sqlSession = getSqlSession();
        ExWarehousingDao exWarehousingDao = sqlSession.getMapper(ExWarehousingDao.class);

        List<ExWarehousing> exWarehousingList = exWarehousingDao.findExWarehousingByStatus(status);
        sqlSession.close();

        return exWarehousingList;
    }

    public void updateExWarehousingStatus(int exWarehousingId, int inventoryManagerId, Status status) {
        SqlSession sqlSession = getSqlSession();
        ExWarehousingDao exWarehousingDAO = sqlSession.getMapper(ExWarehousingDao.class);

        try {
            exWarehousingDAO.updateExWarehousingStatus(exWarehousingId, inventoryManagerId, status);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }
    }

    public List<ExWarehousing> findExWarehousingByPublisher(int publisherId) {
        SqlSession sqlSession = getSqlSession();
        ExWarehousingDao exWarehousingDAO = sqlSession.getMapper(ExWarehousingDao.class);

        List<ExWarehousing> exWarehousingList = exWarehousingDAO.findExWarehousingByPublisher(publisherId);
        sqlSession.close();

        return exWarehousingList;
    }

    public List<ExWarehousing> findExWarehousingByPublisherManagerId(int publisherManagerId) {
        SqlSession sqlSession = getSqlSession();
        ExWarehousingDao exWarehousingDao = sqlSession.getMapper(ExWarehousingDao.class);

        List<ExWarehousing> exWarehousingList = exWarehousingDao.findExWarehousingByPublisherManager(publisherManagerId);
        sqlSession.close();
        return exWarehousingList;
    }

    public List<ExWarehousing> findExWarehousingByPublisherIdAndStatus(int publisherId, Status status) {
        SqlSession sqlSession = getSqlSession();
        ExWarehousingDao exWarehousingDao = sqlSession.getMapper(ExWarehousingDao.class);

        List<ExWarehousing> exWarehousingList = exWarehousingDao.findExWarehousingByPublisherIdAndStatus(publisherId, status);
        sqlSession.close();
        return exWarehousingList;
    }

    public List<ExWarehousing> findExWarehousingByPublisherManagerIdAndStatus(int publisherManagerId, Status status) {
        SqlSession sqlSession = getSqlSession();
        ExWarehousingDao exWarehousingDao = sqlSession.getMapper(ExWarehousingDao.class);

        List<ExWarehousing> exWarehousingList = exWarehousingDao.findExWarehousingByPublisherManagerIdAndStatus(publisherManagerId, status);
        return exWarehousingList;
    }
}
