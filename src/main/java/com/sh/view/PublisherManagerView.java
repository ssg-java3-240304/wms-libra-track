package com.sh.view;

import com.sh.controller.PublisherManagerController;
import com.sh.model.entity.MemberDto;
import com.sh.model.entity.Role;
import com.sh.model.service.PublisherManagerService;

import java.util.Scanner;

//홍지민 작업 시작
public class PublisherManagerView {
    Scanner sc = new Scanner(System.in);
    PublisherManagerController publisherManagerController = new PublisherManagerController();

    public void choicePublisher() {
        System.out.println("출판사를 선택해주세요 : ");
        String choice = sc.next();


    }

    public void choicePublisherMenu() {
        String choicePublisherMenu = """
                 📖📖📖메뉴를 선택해주세요📖📖📖
                 =============================
                 1. 회원 정보 관리
                 2. 도서 관리
                 3. 입/출고 관리
                 =============================
                :
                 """;
        while (true) {
            System.out.println(choicePublisherMenu);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    publisherManagement();
//            case 2 : BookView.(); break;
//            case 3 : InventoryView(); break;
                default:
                    System.out.print("잘못된 입력입니다. 다시 입력해주세요 : ");
                    ;
            }
        }

    }

    private void publisherManagement() {
        String publihserManagement = ("""
            ℹ️ 회원 정보 관리 ℹ️
            ==================
            1. 회원 정보 조회
            2. 회원 정보 수정
            3. 회원 정보 삭제
            ==================
            :
            """);
        while(true) {
            System.out.println(publihserManagement);
            int choice = sc.nextInt();
            switch (choice) {
                case 1 :
                    publisherManagerController.findPublisherManager(); break;
                case 2 :
//                    publisherManagerController.updatePublisherManager(); break;
                case 3 :
//                    publisherManagerController.deletePublisherManager(); break;
            }
        }
    }

}
//홍지민 작업 끝
