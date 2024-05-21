package com.sh.model.dto.inventoryDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {
    private int inventoryId;
    private String location;
    private int capacity;
}
