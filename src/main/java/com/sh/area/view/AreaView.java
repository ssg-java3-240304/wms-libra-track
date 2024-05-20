package com.sh.area.view;

import com.sh.area.controller.AreaController;
import com.sh.area.model.dto.AreaDto;
import com.sh.inventory.controller.InventoryController;

import java.util.HashMap;
import java.util.Scanner;

/**
 * <pre>
 * View단 
 * - 사용자인터페이스 담당
 * - 콘솔구역 제공, 사용자입력값 처리, 요청에 대한 응답 출력
 * - 사용자 요청에 따른 컨트롤러단에 메시지 전송
 * </pre> 
 */
public class AreaView {
    private AreaController areaController = new AreaController();
    private InventoryController inventoryController = new InventoryController();
    private Scanner sc = new Scanner(System.in);

    public void areaMenu() {
        String menu = """
            ==============================================================================================
            1. 전체 구역 조회
            2. 구역 코드로 구역 조회
            3. 창고 코드별 구역 조회
            4. 구역 등록
            5. 구역 수정
            6. 구역 삭제
            7. 구역 reserved 수정
            8. 창고 위치와 구역 이름으로 구역 조회
            0. 종료
            ==============================================================================================
            입력 : """;
        while(true) {
            System.out.print(menu);
            String choice = sc.next();
            switch (choice) {
                case "1" : areaController.findAllArea(); break;
                case "2" : areaController.findAreaByAreaId(inputAreaId("조회")); break;
                case "3" : areaController.findAreaByInventoryId(inputInventoryId()); break;
                case "4" : areaController.insertArea(inputArea()); break;
                case "5" : areaController.updateArea(inputAreaUpdated()); break;
                case "6" : areaController.deleteArea(inputAreaId("삭제")); break;
                case "7" : areaController.updateReserved(inputAreaReservedUpdated()); break;
                case "8" : areaController.findByLocationAndAreaName(inputLocation(), inputAreaName()); break;
                case "0" : return;
                default:
                    System.out.println("잘못 입력하셨습니다.");
            }
        }
    }

    private AreaDto inputAreaUpdated() {
        System.out.println("> ✏️✏️✏️ 수정할 구역 정보를 작성해주세요. ✏️✏️✏️");
        areaController.findAllArea();
        System.out.println("> 수정하고 싶은 구역의 코드 : ");
        int areaId = sc.nextInt();
        System.out.println("> 수정된 창고 코드 : ");
        int inventoryId = sc.nextInt();
        System.out.println("> 수정된 출판사 코드 : ");
        int publisherId = sc.nextInt();
        System.out.println("> 수정된 구역 이름 : ");
        String areaName = sc.next();
        System.out.println("> 수정된 구역 용량 : ");
        int capacity = sc.nextInt();
        System.out.println("> 구역에 예약된 책의 양: ");
        int reserved = sc.nextInt();
        System.out.println("> 구역에 저장된 책의 양 : ");
        int quantity = sc.nextInt();
        return new AreaDto(areaId, inventoryId, publisherId, areaName, capacity, reserved, quantity);
    }
    private AreaDto inputAreaReservedUpdated() {
        System.out.println("> ✏️✏️✏️ 수정할 구역 정보를 작성해주세요. ✏️✏️✏️");
        areaController.findAllArea();
        System.out.println("> 수정하고 싶은 구역의 코드 : ");
        int areaId = sc.nextInt();
        AreaDto areaDto = areaController.findReservedAreaByAreaId(areaId);
        System.out.println("> 수정될 구역에 예약된 책의 양: ");
        int quantity = sc.nextInt();
        return new AreaDto(areaId, areaDto.getInventoryId(), areaDto.getPublisherId(), areaDto.getAreaName(), areaDto.getCapacity(), areaDto.getReserved() + quantity, areaDto.getQuantity());
    }

    private AreaDto inputArea() {
        System.out.println("> ✏️✏️✏️ 등록할 구역 정보를 작성해주세요. ✏️✏️✏️");
        inventoryController.findAllInventory();
        System.out.println("> 창고 코드 : ");
        int inventoryId = sc.nextInt();
        areaController.findAllArea();
        System.out.println("> 구역 이름 : ");
        String areaName = sc.next();
        System.out.println("> 구역 용량 : ");
        int capacity = sc.nextInt();
        System.out.println("> 구역에 예약된 책의 양: ");
        int reserved = sc.nextInt();
        System.out.println("> 구역에 저장된 책의 양 : ");
        int quantity = sc.nextInt();
        return new AreaDto(0, inventoryId, 0, areaName, capacity, reserved, quantity);
    }

    private int inputAreaId(String type) {
        System.out.printf("> %s할 구역코드 : ", type);
        return sc.nextInt();
    }

    private int inputQuantity() {
        System.out.print("> 수정할 구역 reserved의 양 : ");
        return sc.nextInt();
    }

    private int inputInventoryId() {
        inventoryController.findAllInventory();
        System.out.print("> 조회할 창고 코드 : ");
        return sc.nextInt();
    }
    private String inputLocation() {
        System.out.print("> 조회할 창고 위치 : ");
        return sc.next();
    }
    private String inputAreaName() {
        System.out.print("> 조회할 구역 이름 : ");
        return sc.next();
    }

}
