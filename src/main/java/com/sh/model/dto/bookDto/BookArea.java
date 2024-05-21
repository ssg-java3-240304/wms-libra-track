package com.sh.model.dto.bookDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

//창고구역 매퍼
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookArea {
    private int bookAreaId;
    private int areadId;
    private int bookId;
    private int quantity;
    private  int reserved;

}
