package com.sh.model.dao;


import com.sh.model.dto.bookDto.Book;

import java.util.List;

public interface BookDAO {

    int insertBook(Book book);

    Book findBookByISBN(String isbn);

    int updateMenu(Book book);

    int deleteBook(String ISBN);

   List<Book> findAll();


}
