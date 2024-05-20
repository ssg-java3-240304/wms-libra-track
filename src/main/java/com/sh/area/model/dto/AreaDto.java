package com.sh.area.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

// 하나의 창고의 하나의 구역
public class AreaDto {
    private int areaId;
    private int inventoryId;
    private int publisherId;
    private String areaName;
    private int capacity;
    private int reserved;
    private int quantity;
}
