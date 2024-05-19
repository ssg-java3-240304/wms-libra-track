package com.sh;

import com.sh.model.dao.BookDAO;
import com.sh.model.dao.GenreDAO;

import com.sh.model.dao.PublisherDAO;
import com.sh.model.dto.bookDto.Book;
import com.sh.model.dto.publishserDto.PublisherManager;
import org.apache.ibatis.session.SqlSession;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import static com.sh.common.MyBatisTemplate.getSqlSession;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class inputTest {
    Scanner scanner = new Scanner(System.in);
    private SqlSession sqlSession;
    private BookDAO bookDAO;
    private GenreDAO genreDAO;

    private PublisherDAO publisherDAO;

    @BeforeEach
    void setUp() {
        sqlSession = getSqlSession();
        bookDAO = sqlSession.getMapper(BookDAO.class);
        genreDAO = sqlSession.getMapper(GenreDAO.class);
        publisherDAO = sqlSession.getMapper(PublisherDAO.class);
    }

    @AfterEach
    void tearDown() {
        this.sqlSession.commit();
        this.sqlSession.rollback();
    }


    @Test
    @DisplayName("책 정보 입력 테스트")
    void test1 () {
        //given
        PublisherManager publisherManager = new PublisherManager(1,1);
        int publisherId = publisherManager.getPublisherId();
//        System.out.println("책의 정보 입력");
//        System.out.print("책 이름 : ");
        String title = "오행동책";
//        System.out.print("ISBN 코드 : ");
        String ISBN = "ISBN1234";
//        System.out.print("책 가격 : ");
        int price = 15000;
//        System.out.print("책 출판 날짜 : ");
        LocalDateTime pubDate = LocalDateTime.now();
//        System.out.print("책 저자 : ");
        String author ="홍길동";
//        System.out.print("책 페이지 수 : ");
        int page =324;
//        System.out.print("책 크기 : ");
        String size = "225";
//        System.out.print("책 장르 : ");
        int genreId = 3;
//        String genreName = "소설";
//        Genre genre = Genre.valueLabel(genreName);
        Book book= new Book(0, title, ISBN, publisherId, pubDate, price, author, page, size, genreId);

        int result = bookDAO.insertBook(book);
//        int result = bookDAO.updateInforamtion(book);

        Assertions.assertThat(result).isEqualTo(1);

    }

    @Disabled
    @Test
    @DisplayName("장르 아이디 가져오는 메소드")
    void test2() {
        //given
        String genreName = "문학";
        //when
        int id = genreDAO.findGenreId(genreName);
        //then
        Assertions.assertThat(id).isEqualTo(3);
    }

    @Disabled
    @Test
    @DisplayName("ISBN으로 북의 정보 찾기")
    void test3() {
        //given
        String ISBN = "ISBN1234";
        //when
        Book book = bookDAO.findBookByISBN(ISBN);
        System.out.println(book);
        //then
        Assertions.assertThat(book.getISBN()).isEqualTo(ISBN);

    }

    @Disabled
    @Test
    @DisplayName("책 가격 정보 수정하기")
    void test4() {
        //given
        String ISBN = "ISBN1234";
        int page = 200;
        int price = 40000;
        String size = "500";
        //when
        Book book = new Book(ISBN, price, page, size);
        int result = bookDAO.updateMenu(book);
        System.out.println(book);
        //then
        Assertions.assertThat(result).isEqualTo(1);
    }
    @Disabled
    @Test
    @DisplayName("책 상세정보 삭제하기 ")
    void test5 () {
        //given
        String ISBN = "ISBN4444";
        //when
        int result = bookDAO.deleteBook(ISBN);
        //then
        Assertions.assertThat(result).isEqualTo(1);
    }


    @Test
    @DisplayName("출판 등록된 모든 책 조회 하기 ")
    void test6() {
        //given
        PublisherManager publisherManager = new PublisherManager(1, 1);
        int id = publisherManager.getPublisherId();
        //when
        List<Book> list = bookDAO.findAll(id);
        System.out.println(list);
        //then
        assertThat(list).isNotNull();
    }

    @Disabled
    @Test
    @DisplayName("출판사의 id 출력하기 ")
    void test7() {
        //given
        String publisherName = "오동동";
        //when
        int publisherId = publisherDAO.getPublisherId(publisherName);
        //then
        Assertions.assertThat(publisherId).isEqualTo(3);

    }
}
