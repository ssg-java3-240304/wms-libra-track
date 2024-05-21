package com.sh.view;

import com.sh.controller.AdminUserContoller;
import com.sh.inventory.view.InventoryView;
import com.sh.model.entity.MemberDto;

import java.util.Scanner;

public class AdminUserView {
    Scanner sc = new Scanner(System.in);
    InventoryView inventoryView = new InventoryView();
    //    Publisher publisher = new publisherView(); //✅ 출판 관리 뷰 객체 생성
    AdminUserContoller adminUserContoller = new AdminUserContoller();

    public void choiceAdminMenu(MemberDto memberDto) {
        String adminMenu = ("""
                📖📖📖 Admin User 메뉴 📖📖📖
                ==============================
                1. 회원 관리 메뉴
                2. 창고 관리 메뉴
                3. 출판사 관리 메뉴
                4. 나가기
                =============================
                입력 : 
                """);
        while (true) {
            System.out.print(adminMenu);
            int choice = sc.nextInt();

            switch (choice) {
                case 1 :
                    adminUserManagement(memberDto);
                case 2:
                    inventoryView.inventoryMenu();
                    break;
                case 3:
//                    publisher.publisherMenu();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("잘못 입력했습니다. 다시 입력해주세요!");
            }
        }
    }

    private void adminUserManagement(MemberDto memberDto) {
        String adminUserManagement = ("""
                ===================
                ℹ️ 회원 정보 관리 ℹ️
                ===================
                 1. 회원 정보 조회
                 2. 회원 정보 수정
                 3. 나가기
                ===================
                """);
        while (true) {
            System.out.print(adminUserManagement);
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    adminUserContoller.findAdminUserInfo(memberDto);
                    break;
                case 2:
                    adminUserContoller.findAdminUserInfo(memberDto);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("잘못 입력된 값입니다. 다시 입력해수제요!");
            }
        }
    }
}
