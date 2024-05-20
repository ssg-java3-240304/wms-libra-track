package com.sh.model.dto.publishserDto;

import com.sh.model.dto.bookDto.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Publisher {

    private int publisherId;
    private String name;
    private String email;
    private String phoneNumber;
    private String businessNumber;



//    출판사가 가지고 있는 책의 정보를 확인해야함.
//    private List<Book> bookList = new ArrayList<>();
}
