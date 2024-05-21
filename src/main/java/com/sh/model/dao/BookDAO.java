package com.sh.model.dao;


import com.sh.model.dto.bookDto.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BookDAO {

    int insertBook(Book book);

    Book findBookByISBN(String isbn);

    int updateInforamtion(Book book);

    int deleteBook(String ISBN);

   List<Book> findAll(int id);



        int findBookIdByPublisherIdAndISBN(Map<String, Object> param);

}
