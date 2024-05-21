package com.sh.model.dto.inventoryDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryArea {
    private int areadId;
    private String areaNumber;
    private int capacity;
    private int inventoryId;
    private int publisherId;
    private int reserved;
}
