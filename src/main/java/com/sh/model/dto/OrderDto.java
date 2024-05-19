package com.sh.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private int orderId;
    private int bookId;
    private int quantity;
    private String ISBN;
    private String title;
    private String author;

}
