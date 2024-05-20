package com.sh.model.service.bookService;

import com.sh.model.dao.BookDAO;
import com.sh.model.dao.GenreDAO;

import com.sh.model.dto.bookDto.Book;
import com.sh.view.bookView.bookResultView.DisplayResultView;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Optional;

import static com.sh.common.MyBatisTemplate.getSqlSession;

public class BookService {
    SqlSession sqlSession;
    BookDAO bookDAO;
//    public void common(){
//        sqlSession = getSqlSession();
//        bookDAO = sqlSession.getMapper(BookDAO.class);
//    }
    public int getGenreId(String genreName) {
        SqlSession sqlSession = getSqlSession();
        GenreDAO genreDao = sqlSession.getMapper(GenreDAO.class);
        int genreId = genreDao.findGenreId(genreName);

        return genreId;
    }

    public int insertBook(Book book) {
        SqlSession sqlSession = getSqlSession();
        BookDAO bookDAO = sqlSession.getMapper(BookDAO.class);
        try{
            int result = bookDAO.insertBook(book);
            sqlSession.commit();
            return result;
        }catch(Exception e){
            sqlSession.rollback();
            throw new RuntimeException(e);
        }finally{
            sqlSession.close();
        }

    }


    public Book findBookByISBN(String isbn) {
        SqlSession sqlSession =getSqlSession();
        BookDAO bookDAO = sqlSession.getMapper(BookDAO.class);

        Book book = bookDAO.findBookByISBN(isbn);
        return book;
    }

    public int updateInforamtion(Book book) {
        SqlSession sqlSession = getSqlSession();
        BookDAO bookDAO = sqlSession.getMapper(BookDAO.class);
        try{
            int result = bookDAO.updateInforamtion(book);
            sqlSession.commit();
            return result;

        }catch (Exception e){
            sqlSession.rollback();
            throw new RuntimeException(e);
        }finally {
            sqlSession.close();
        }

    }

    public int deleteBook(String ISBN) {
        SqlSession sqlSession = getSqlSession();
        BookDAO bookDAO = sqlSession.getMapper(BookDAO.class);
        try {
            int result = bookDAO.deleteBook(ISBN);
            sqlSession.commit();
            return result;
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        }finally{
            sqlSession.close();
        }

    }

    public List<Book> findAll(int id) {
        sqlSession = getSqlSession();
        bookDAO = sqlSession.getMapper(BookDAO.class);
        List<Book> bookList = bookDAO.findAll(id);
        DisplayResultView.displayBookList(bookList);
        return bookList;
    }

    public Book duplicateISBN(String ISBN) {
        return bookDAO.findBookByISBN(ISBN);
    }
}
