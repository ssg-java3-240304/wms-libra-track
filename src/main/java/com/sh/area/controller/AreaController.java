package com.sh.area.controller;

//import com.sh.common.ErrorView;
//import com.sh.common.error.ErrorCode;
//import com.sh.inventory.model.dto.CategoryDto;
import com.sh.area.model.dto.AreaDto;
import com.sh.area.model.service.AreaService;
import com.sh.area.view.AreaResultView;
import com.sh.inventory.model.dto.InventoryDto;

import java.util.HashMap;
import java.util.List;

/**
 * <pre>
 * Controller
 * - mvc구조의 제어부
 * - view단으로 부터 사용자 요청 수집
 * - 사용자 요청에 적합한 Service 선정
 * - Service에 전달할 데이터를 가공 및 요청
 * - 응답에 대한 view처리
 * - 예외처리 (service, dao처리중에 발생된 예외수집, 로깅, 사용자 전달)
 * </pre>
 */
public class AreaController {
    private AreaService areaService = new AreaService();

    public void findAllArea() {
        // n개의 InventoryDto 반환 : List<InventoryDto>
        List<AreaDto> list = areaService.findAllArea();
        AreaResultView.displayAreaList(list);
    }

    public void findAreaByAreaId(int areaId) {
        // 0~1개의 InventoryDto 반환 : InventoryDto
        AreaDto areaDto = areaService.findAreaByAreaId(areaId);
        AreaResultView.displayArea(areaDto);
    }
    public void findByLocationAndAreaName(HashMap<String, String> map) {
        // 0~1개의 InventoryDto 반환 : InventoryDto
        AreaDto areaDto = areaService.findByLocationAndAreaName(map);
        AreaResultView.displayArea(areaDto);
    }

    public AreaDto findReservedAreaByAreaId(int areaId) {
        // 0~1개의 InventoryDto 반환 : InventoryDto
        return areaService.findAreaByAreaId(areaId);
    }

    public void insertArea(AreaDto areaDto) {
        int result = areaService.insertArea(areaDto);
        AreaResultView.displayResult("구역 등록", result);
    }

    public void updateArea(AreaDto areaDto) {
        int result = areaService.updateArea(areaDto);
        AreaResultView.displayResult("구역 수정", result);
    }

    public void updateReserved(AreaDto areaDto) {
        int result = areaService.updateReserved(areaDto);
        AreaResultView.displayResult("구역 reserved 수정", result);
    }

    public void deleteArea(int areaId) {
        int result = areaService.deleteArea(areaId);
        AreaResultView.displayResult("구역 삭제", result);
    }

    public void findAreaByInventoryId(int categoryCode) {
        List<AreaDto> list = areaService.findAreaByInventoryId(categoryCode);
        AreaResultView.displayAreaList(list);
    }

    public void findAllInventory() {
        List<InventoryDto> inventoryList = areaService.findAllInventory();
        AreaResultView.displayInventoryList(inventoryList);
    }

//    public void insertCategoryAndMenu(CategoryDto categoryDto, InventoryDto inventoryDto) {
//        int result = menuService.insertCategoryAndMenu(categoryDto, menuDto);
//        ResultView.displayResult("카테고리 & 메뉴 등록", result);
//    }

//    public void findMenuOrderable() {
//        List<InventoryDto> list = inventoryService.findMenuOrderable();
//        ResultView.displayInventoryList(list);
//    }
//
//    public List<InventoryDto> findMenuOrderableByCategoryCode(int categoryCode) {
//        List<InventoryDto> list = inventoryService.findMenuOrderableByCategoryCode(categoryCode);
//        ResultView.displayInventoryList(list);
//        return list;
//    }
}
