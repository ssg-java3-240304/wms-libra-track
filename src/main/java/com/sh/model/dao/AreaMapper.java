package com.sh.model.dao;

import com.sh.model.dto.AreaDto;
import com.sh.model.dto.InventoryDto;

import java.util.HashMap;
import java.util.List;

public interface AreaMapper {
    List<AreaDto> findAllArea();
    AreaDto findAreaByAreaId(int areaId);
    int insertArea(AreaDto areaDto);
    int updateArea(AreaDto areaDto);
    int deleteArea(int areaId);
    List<AreaDto> findAreaByAreaName(String areaName);
    List<AreaDto> findAreaByCapacity(int capacity);
    int updateReserved(AreaDto areaDto);
    AreaDto findByLocationAndAreaName(HashMap<String, String> map);

    List<AreaDto> findAreaByInventoryId(int inventoryId);
    List<InventoryDto> findAllInventory();
}
