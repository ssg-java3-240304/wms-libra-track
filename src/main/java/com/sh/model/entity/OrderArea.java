package com.sh.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

//홍지민 작업 시작
public class OrderArea {
    private int orderAreaId;
    private int bookAreaId;
    private int orderId;
}
// 홍지민 작업 끝