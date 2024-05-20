package com.sh.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

//홍지민 작업 시작
public class ExWarehousing {
    private int exWarehousingId;
    private String address;
    private String receiver;
    private String receiverPhone;
    private String receiverEmail;
    private Timestamp date;
    private List<Order> orderList;
    private Status status;
}
//홍지민 작업 끝