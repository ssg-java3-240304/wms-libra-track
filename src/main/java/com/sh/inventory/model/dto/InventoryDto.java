package com.sh.inventory.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

// 하나의 창고
public class InventoryDto {
    private int inventoryId;
    private String location;
    private int capacity;

//    private List<Area> areaList = new ArrayList<>();
//    private List<InventoryManager> inventoryManagerList = new ArrayList<>();
}
