package com.sh.inventory.controller;

//import com.sh.common.ErrorView;
//import com.sh.common.error.ErrorCode;
//import com.sh.inventory.model.dto.CategoryDto;
import com.sh.inventory.model.dto.InventoryDto;
import com.sh.inventory.model.service.InventoryService;
import com.sh.inventory.view.InventoryResultView;

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
public class InventoryController {
    private InventoryService inventoryService = new InventoryService();

    public void findAllInventory() {
        // n개의 InventoryDto 반환 : List<InventoryDto>
        List<InventoryDto> list = inventoryService.findAllInventory();
        InventoryResultView.displayInventoryList(list);
    }

    public void findInventoryByInventoryId(int inventoryId) {
        // 0~1개의 InventoryDto 반환 : InventoryDto
        InventoryDto inventoryDto = inventoryService.findInventoryByInventoryId(inventoryId);
        InventoryResultView.displayInventory(inventoryDto);
    }

    public void insertInventory(InventoryDto inventoryDto) {
        int result = inventoryService.insertInventory(inventoryDto);
        InventoryResultView.displayResult("창고 등록", result);
    }

//    public void insertCategoryAndMenu(CategoryDto categoryDto, InventoryDto inventoryDto) {
//        int result = menuService.insertCategoryAndMenu(categoryDto, menuDto);
//        ResultView.displayResult("카테고리 & 메뉴 등록", result);
//    }

//    public void findByCategoryCode(int categoryCode) {
//        List<InventoryDto> list = inventoryService.findByCategoryCode(categoryCode);
//        ResultView.displayInventoryList(list);
//    }

    public void updateInventory(InventoryDto inventoryDto) {
        int result = inventoryService.updateInventory(inventoryDto);
        InventoryResultView.displayResult("창고 수정", result);
    }

    public void deleteInventory(int inventoryId) {
        int result = inventoryService.deleteInventory(inventoryId);
        InventoryResultView.displayResult("창고 삭제", result);
    }

//    public void findAllCategory() {
//        List<CategoryDto> categoryList = inventoryService.findAllCategory();
//        ResultView.displayCategoryList(categoryList);
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
