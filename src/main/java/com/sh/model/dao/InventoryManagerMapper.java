package com.sh.model.dao;

import com.sh.model.entity.InventoryManagerDto;

public interface InventoryManagerMapper {
    

    int insertInventoryManager(InventoryManagerDto inventoryManagerDto);


    InventoryManagerDto findAll(int memberId);
}