package com.sh.view;

import com.sh.controller.InventoryManagerController;
import com.sh.controller.MemberController;
import com.sh.controller.PublisherManagerController;
import com.sh.model.entity.InventoryManagerDto;
import com.sh.model.entity.MemberDto;

import java.util.Scanner;

public class InventoryManagerView {
    Scanner sc = new Scanner(System.in);
    InventoryManagerController inventoryManagerController = new InventoryManagerController();
    MemberController memberController = new MemberController();


    public void choiceInventoryManagerMenu(MemberDto memberDto) {
        String choiceInventoryManagerMenu = """
                 📖📖📖메뉴를 선택해주세요📖📖📖
                 =============================
                 1. 회원 정보 관리
                 2. 창고 관리 
                 3. 입/출고 관리
                 =============================
                :
                 """;
        while (true) {
            System.out.println(choiceInventoryManagerMenu);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    inventoryManagerManagement(memberDto);
//            case 2 : BookView.(); break;
//            case 3 : InventoryView(); break;
                default:
                    System.out.print("잘못된 입력입니다. 다시 입력해주세요 : ");
                    ;
            }
        }

    }

    private void inventoryManagerManagement(MemberDto memberDto) {
        String inventoryManagerManagement = ("""
            ℹ️ 회원 정보 관리 ℹ️
            ==================
            1. 회원 정보 조회
            2. 회원 정보 수정
            3. 회원 정보 삭제
            
            ==================
            :
            """);
        while(true) {
            System.out.println(inventoryManagerManagement);
            int choice = sc.nextInt();
            switch (choice) {
                case 1 :
                    InventoryManagerDto inventoryManagerInfo = inventoryManagerController.findAll(memberDto.getMemberId());
                    System.out.println("========조회한 매니저님의 정보입니다 ============");
                    System.out.println(inventoryManagerInfo);
                break;
                case 2 :
                    updateInventoryInfo(memberDto);
                break;

                case 3 :
                    deleteInfo(memberDto);
                break;
            }
        }
    }

        private void updateInventoryInfo(MemberDto memberDto){
            String updateSentence = ("""
                    ===========================
                    1. 아이디  변경
                    2. 비밀번호 변경
                    3. 핸드폰번호 변경
                    4. email 변경
                    ===========================
                    """);
            while (true){
                System.out.println(updateSentence);
                int choice = sc.nextInt();
                switch (choice){
                    case 1 :
                        System.out.println("====변경할 아이디 입력해 주세요=====");
                        String userName = sc.next();
                        MemberDto updateId = new MemberDto(memberDto.getMemberId(), userName);
                        inventoryManagerController.updateId(updateId);
                        break;

                    case 2 :
                        System.out.println("====변경할 비밀번호 입력해 주세요=====");
                        String password = sc.next();
                        MemberDto updatedPassword = new MemberDto(password, memberDto.getMemberId());
                        inventoryManagerController.updatePassword(updatedPassword);
                        break;
                    case 3 :
                        System.out.println("==== 변경할 핸드폰 번호 입력 ======");
                        String phoneNumber = sc.next();
                        MemberDto updatedPhoneNumber = new MemberDto(phoneNumber);
                        inventoryManagerController.updatePhoneNumber(updatedPhoneNumber);
                        break;


                }
            }

        }

        private void deleteInfo(MemberDto memberDto){
            String deleteInfo = ("""
                    =====회원 탈퇴=====
                    1.예
                    2.아니요
                    """);
            while(true){
                System.out.println(deleteInfo);
                int choice = sc.nextInt();
                switch (choice){
                    case 1 :
                        memberController.deleteInfo(memberDto);
                        break;



                }
            }
        }
}

