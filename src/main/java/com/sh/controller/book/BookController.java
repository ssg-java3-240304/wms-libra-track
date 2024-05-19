package com.sh.controller.book;


import com.sh.common.error.ErrorCode;
import com.sh.common.error.ErrorView;
import com.sh.model.dto.bookDto.Book;
import com.sh.model.service.bookService.BookService;
import com.sh.view.bookView.bookResultView.DisplayResultView;

public class BookController {
    BookService bookService = new BookService();

    public void findAll(int id){
        bookService.findAll(id);
    }
    public int getGenreId(String genreName) {
        return bookService.getGenreId(genreName);
    }

    public void insertBook(Book book) {
        int result = bookService.insertBook(book);

        DisplayResultView.displayResult("등록", result);
    }

    public Book findBookByISBN(String ISBN) {

        try {
            Book book = bookService.findBookByISBN(ISBN);
            DisplayResultView.displayBook(book);
            return book;
        } catch (Exception e) {
            e.printStackTrace();
            ErrorView.displayError(ErrorCode.FAIL_SEARCH_ISBN);
            return null;
        }
    }

    public void udpateMenu(Book book) {
        int result = bookService.updateMenu(book);
        Book newBook = bookService.findBookByISBN(book.getISBN());
        DisplayResultView.displayBook(newBook);
    }

    public void deleteBook(String ISBN) {
        try {
            int result =  bookService.deleteBook(ISBN);
            DisplayResultView.displayResult("삭제",result);
        } catch (Exception e) {
            e.printStackTrace();
            ErrorView.displayError(ErrorCode.FAIL_SEARCH_ISBN);
        }
    }

}
