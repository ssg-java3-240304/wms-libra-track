package com.sh.view;

import com.sh.controller.InventoryManagerController;
import com.sh.controller.PublisherManagerController;
import com.sh.model.entity.InventoryManagerDto;
import com.sh.model.entity.MemberDto;
import com.sh.model.entity.PublisherManagerDto;
import com.sh.view.bookView.BookMenuView;

import java.util.Scanner;

import static com.sh.WMSApplication.*;
import static com.sh.view.MemberView.EX;

public class InventoryManagerView {

    Scanner sc = getScanner();

    BookMenuView bookMenuView = new BookMenuView();

    InventoryManagerController inventoryManagerController = new InventoryManagerController();

    public void inventoryManagerMainView(MemberDto memberDto) {
        String choicePublisherMenu = """
                📖📖📖출판사 매니저 메뉴📖📖📖
                =============================
                1. 입고 관리
                2. 출고 관리
                0. 나가기
                =============================
                입력 : 
                """;
        InventoryManagerDto inventoryManagerDto = inventoryManagerController.findPublisherManagerInfo(memberDto);


        if (inventoryManagerDto != null) {
            PUB_MANAGER_ID = publisherManagerDto.getPublisherManagerId();
            PUB_ID = publisherManagerDto.getPublisherId();
        }

        while (true) {

            if(publisherManagerDto == null) {
                publisherManagerDto = publisherManagerController.findPublisherManagerInfo(memberDto);

                if (publisherManagerDto != null) {
                    PUB_MANAGER_ID = publisherManagerDto.getPublisherManagerId();
                    PUB_ID = publisherManagerDto.getPublisherId();
                }
            }
            System.out.print(choicePublisherMenu);
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    publisherManagement(memberDto);
                    break;
                case 2 :
                    if (publisherManagerDto == null) {
                        System.out.println("출판사 정보가 없습니다. 출판사 정보를 먼저 등록해주세요.");
                        break;
                    }
                    bookMenuView.showMenu();
                    break;
                case 3 :
                    if (publisherManagerDto == null) {
                        System.out.println("출판사 정보가 없습니다. 출판사 정보를 먼저 등록해주세요.");
                        break;
                    }
                    EX = false;
                    InWarehousingView.inWarehousingPublisherMainMenu(); break;
                case 4 :
                    if (publisherManagerDto == null) {
                        System.out.println("출판사 정보가 없습니다. 출판사 정보를 먼저 등록해주세요.");
                        break;
                    }
                    EX = true;
                    ExWarehousingView.exWarehousingPublisherMainMenu(); break;
                case 0 :
                    return;
                default:
                    System.out.print("잘못된 입력입니다. 다시 입력해주세요 : ");
            }
        }
    }



}
