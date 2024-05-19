package com.sh.inventory.view;

import com.sh.inventory.controller.InventoryController;
//import com.sh.menu.model.dto.CategoryDto;
import com.sh.inventory.model.dto.InventoryDto;

import java.util.Scanner;

/**
 * <pre>
 * View단 
 * - 사용자인터페이스 담당
 * - 콘솔창고 제공, 사용자입력값 처리, 요청에 대한 응답 출력
 * - 사용자 요청에 따른 컨트롤러단에 메시지 전송
 * </pre> 
 */
public class InventoryView {
    private InventoryController inventoryController = new InventoryController();
    private Scanner sc = new Scanner(System.in);

    public void inventoryMenu() {
        String menu = """
            ==========================================
            1. 전체 창고 조회
            2. 창고 코드로 창고 조회
//            3. 위치별 창고 조회
            4. 창고 등록
            5. 창고 수정
            6. 창고 삭제
//            7. 카테고리 & 창고 등록
//            8. 용량별 창고 조회
//            9. 주문가능한 카테고리별 창고 조회
            0. 종료
            ==========================================
            입력 : """;
        while(true) {
            System.out.print(menu);
            String choice = sc.next();
            switch (choice) {
                case "1" : inventoryController.findAllInventory(); break;
                case "2" : inventoryController.findInventoryByInventoryId(inputInventoryId("조회")); break;
//                case "3" : menuController.findByCategoryCode(inputCategoryCode()); break;
                case "4" : inventoryController.insertInventory(inputInventory()); break;
                case "5" : inventoryController.updateInventory(inputInventoryUpdated()); break;
                case "6" : inventoryController.deleteInventory(inputInventoryId("삭제")); break;
//                case "7" : menuController.insertCategoryAndMenu(inputCategory(), inputMenu()); break;
//                case "8" : menuController.findMenuOrderable(); break;
//                case "9" : menuController.findMenuOrderableByCategoryCode(inputCategoryCode()); break;
                case "0" : return;
                default:
                    System.out.println("잘못 입력하셨습니다.");
            }
        }
    }

    private InventoryDto inputInventoryUpdated() {
        System.out.println("> ✏️✏️✏️ 수정할 창고 정보를 작성해주세요. ✏️✏️✏️");
        System.out.println("> 수정하고 싶은 창고의 코드 : ");
        int inventoryId = sc.nextInt();
        System.out.println("> 수정된 창고 위치 : ");
        String location = sc.next();
        System.out.println("> 수정된 창고 용량 : ");
        int capacity = sc.nextInt();
        return new InventoryDto(inventoryId, location, capacity);
    }

//    private int inputCategoryCode() {
//        System.out.println("> 조회할 카테고리코드 : ");
//        displayCategoryList();
//        return sc.nextInt();
//    }

//    /**
//     * <pre>
//     * 카테고리 출력 (하위 카테고리만)
//     * > 4.한식 5.중식 6.일식 ...
//     * </pre>
//     */
//    private void displayCategoryList() {
//        inventoryController.findAllCategory();
//    }
//
//    private CategoryDto inputCategory() {
//        System.out.println("> ✏✏✏ 등록할 카테고리 정보를 작성해주세요. ✏✏✏");
//        System.out.println("> 카테고리명 : ");
//        String categoryName = sc.next();
//        System.out.println("> 부모카테고리코드 : ");
//        int refCategoryCode = sc.nextInt();
//        return new CategoryDto(0, categoryName, refCategoryCode);
//    }

    private InventoryDto inputInventory() {
        System.out.println("> ✏️✏️✏️ 등록할 창고 정보를 작성해주세요. ✏️✏️✏️");
        System.out.println("> 창고 위치 : ");
        String location = sc.next();
        System.out.println("> 창고 용량 : ");
        int capacity = sc.nextInt();
//        System.out.println("> 카테고리코드 : ");
//        displayCategoryList();
//        int categoryCode = sc.nextInt();
//        System.out.println("> 주문가능여부(Y/N) : ");
//        String orderableStatus = String.valueOf(sc.next().toUpperCase().charAt(0));
        return new InventoryDto(0, location, capacity);
    }

    private int inputInventoryId(String type) {
        System.out.printf("> %s할 창고코드 : ", type);
        return sc.nextInt();
    }
}
