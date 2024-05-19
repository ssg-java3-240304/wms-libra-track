package com.sh.model.entity;

import com.mysql.cj.protocol.a.TimeTrackingPacketSender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

// 홍지민 작업 시작
public class InWarehousing {
    private int inWarehousingId;
    private Timestamp date;
    private int publisherManagerId;
    private int inventoryManagerId;
    private List<Order> orderList;
    private Status status;
}
// 홍지민 작업 끝