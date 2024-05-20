package com.sh;

import com.sh.model.dao.PublisherDAO;
import com.sh.model.dto.publishserDto.Publisher;
import com.sh.model.dto.publishserDto.PublisherManager;
import org.apache.ibatis.session.SqlSession;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.sh.common.MyBatisTemplate.getSqlSession;

public class publisherTest {

    private SqlSession sqlSession;
    private PublisherDAO publisherDAO;
    @BeforeEach
    void setUp() {
        sqlSession = getSqlSession();
       publisherDAO = sqlSession.getMapper(PublisherDAO.class);
    }

    @AfterEach
    void tearDown() {
        this.sqlSession.commit();
        this.sqlSession.close();
    }

    @Test
    @DisplayName("출판사 정보 추가하기 ")
    void test1() {
        //given
        String name = "오형동출판사1";
        String email = "12@naver.com";
        String phoneNumber = "01011111111";
        String businessNumber = "3333";

        Publisher publisher = new Publisher(0, name, email, phoneNumber, businessNumber);
        //when
        int result = publisherDAO.insertPublisher(publisher);
        //then
        Assertions.assertThat(result).isEqualTo(1);

    }

    @Test
    @DisplayName("출판사 정보 수정하기")
    void test2() {
        //given
        PublisherManager publisherManager = new PublisherManager(1, 1);
        int publisherId = publisherManager.getPublisherId();
        String name = "형동출판사11";
        String email = "123@naver.com";
        String phoneNumber = "0101";
        String businessNumber = "2222";
        //when
        int result = publisherDAO.updatePublisher(new Publisher(publisherId, name, email, phoneNumber, businessNumber));
        //then
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("출판사 정보 확인하기 ")
    void test3() {
        //given
        int publisherId = 1;
        //when
        Publisher publisher = publisherDAO.findPublisherInformation(publisherId);
        System.out.println(publisher);
        //then
        Assertions.assertThat(publisher).isNotNull();

    }
}
