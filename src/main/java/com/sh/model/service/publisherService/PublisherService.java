package com.sh.model.service.publisherService;

import com.sh.model.dao.PublisherDAO;
import com.sh.model.dto.publishserDto.Publisher;
import org.apache.ibatis.session.SqlSession;

import static com.sh.common.MyBatisTemplate.getSqlSession;

public class PublisherService {

    public int getPublisherId(String publisherName) {
        SqlSession sqlSession = getSqlSession();
        PublisherDAO publisherDAO = sqlSession.getMapper(PublisherDAO.class);
        return publisherDAO.getPublisherId(publisherName);
    }

    public int insertPublisher(Publisher publisher) {
        SqlSession sqlSession = getSqlSession();
        PublisherDAO publisherDAO = sqlSession.getMapper(PublisherDAO.class);
        return publisherDAO.insertPublisher(publisher);
    }
}
