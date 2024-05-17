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

//홍지민 개발 시작

public class ExWarehousing {
    private String address;
    private String receiver;
    private String receiverPhone;
    private String receiverEmail;
    private Timestamp date;
    private List<Order> orderList;
    private STATUS;
}

//홍지민 개발 끝