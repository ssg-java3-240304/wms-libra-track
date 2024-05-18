package com.sh.model.dto.bookDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private Integer bookId;
    private String title;
    private String ISBN;
    private Integer publisherId;
    private LocalDateTime pubDate;
    private Integer price;
    private String author;
    private Integer page;
    private String size;
    private Integer genreId;
//    private Genre genre;

    public Book(String ISBN,int price, int page, String size) {
        this.ISBN = ISBN;
        this.price = price;
        this.page = page;
        this.size = size;
    }

}


