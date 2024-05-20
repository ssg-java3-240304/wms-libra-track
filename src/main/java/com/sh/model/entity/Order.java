package com.sh.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

//홍지민 작업 시작
public class Order {
    private int orderId;
    private int quantity;
    private int bookId;
    private int inWarehousingId;
    private int exWarehousingId;
    private List<OrderArea> orderAreaList;
}
// 홍지민 작업 끝
