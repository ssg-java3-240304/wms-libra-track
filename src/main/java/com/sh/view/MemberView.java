package com.sh.view;

import com.sh.controller.MemberController;
//import com.sh.inventory.view.InventoryView;
import com.sh.model.entity.MemberDto;
import com.sh.model.entity.Role;

import java.util.Scanner;

public class MemberView {
    private Scanner sc = new Scanner(System.in);
    private MemberController memberController = new MemberController();

    // 홍지민 작업 시작
    public void mainMenu() {
        String menu = """
               🏭 WMS 도서재고관리 시스템 접속 완료!🏭
              ====================================
                    📑📑📑메뉴 선택📑📑📑
                        1. 회원 가입
                        2. 로그인
                        3. 종료
              ====================================
                """;
        while (true) {
            System.out.print(menu);
            String choice = sc.next();
            switch (choice) {
                case "1":
                    choiceRole(); // 이걸 이름 바꿔서 사용
                    break;
                case "2":
                    loginCheck();
                    break;
                case "3":
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요! ");
            }
        }
    }


    private void choiceRole() {
        String choiceRole = """
                =========================
                 ✅ 회원 선택을 해주세요 ✅
                =========================
                  1. 출판사 매니저
                  2. 창고 관리자
                  3. Adimin User
                  4. 뒤로 가기
                =========================
                """;

        while (true) {
            System.out.print(choiceRole);
            String choice = sc.next();
            switch (choice) {
                case "1":
                    memberController.insertPublisherMember(insertPublisherMember());
                    break;
                case "2":
                    memberController.insertInventoryManager(insertInventoryMember());
                    break;
                case "3":
                    memberController.insertAdminUser(insertAdminUser());
                    break;
                case "4" :
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요!");
            }
        }
    }

    private void loginCheck() {
        System.out.println("""
                =====================
                     ✨ 로그인 ✨
                =====================
                """);
        System.out.print("▶ ID 입력 : ");
        String id = sc.next();
        System.out.print("▶ Password 입력 : ");
        String password = sc.next();
        System.out.println();
        MemberDto memberDto =  memberController.loginCheck(id, password);

        if(memberDto.getRole() == Role.PUBLISHER){
            PublisherManagerView publisherManagerView = new PublisherManagerView();
            publisherManagerView.choicePublisherMenu(memberDto);
        } else if (memberDto.getRole() == Role.INVENTORY) {
            InventoryManagerView inventoryManagerView = new InventoryManagerView();
            inventoryManagerView.choiceInventoryManagerMenu(memberDto);
        } else if(memberDto.getRole() == Role.ADMIN) {
            AdminUserView adminUserView = new AdminUserView();
            adminUserView.choiceAdminMenu(memberDto);
        }
    }

    // AdminUser 회원가입
    private MemberDto insertAdminUser() {
        System.out.println("""
                =====================================
                 📝📝📝 회원 정보를 입력해주세요. 📝📝📝
                =====================================
                """);
        System.out.print("▶ 회원 이름 입력 : ");
        String name = sc.next();
        sc.nextLine();
        System.out.print("▶ ID 입력 : ");
        String userName = sc.next();
        sc.nextLine();
        System.out.print("▶ Password 입력 : ");
        String password = sc.nextLine();
        System.out.print("▶ 전화번호 입력 : ");
        String phoneNumber = sc.nextLine();
        System.out.print("▶ 이메일 입력 : ");
        String email = sc.nextLine();
        return new MemberDto(0, name, userName, password, Role.ADMIN, phoneNumber, email);

    }

    // Publisher 회원가입
    private MemberDto insertPublisherMember() {
        System.out.println("""
                =====================================
                 📝📝📝 회원 정보를 입력해주세요. 📝📝📝
                =====================================
                """);
        System.out.print("▶ 회원 이름 입력 : ");
        String name = sc.next();
        sc.nextLine();
        System.out.print("▶ ID 입력 : ");
        String userName = sc.next();
        sc.nextLine();
        System.out.print("▶ Password 입력 : ");
        String password = sc.nextLine();
        System.out.print("▶ 전화번호 입력 : ");
        String phoneNumber = sc.nextLine();
        System.out.print("▶ 이메일 입력 : ");
        String email = sc.nextLine();
        return new MemberDto(0, name, userName, password, Role.PUBLISHER, phoneNumber, email);
    }
    // 홍지민 작업 끝

    //InventoryManager 회원가입
    private MemberDto insertInventoryMember() {
        System.out.println("> ✏✏✏ 회원 등록할 정보 작성해주세요. ✏✏✏");
        System.out.println("▶ 회원 이름 입력");
        String name = sc.next();
        sc.nextLine();
        System.out.println("▶ username 입력");
        String userName = sc.next();
        sc.nextLine();
        System.out.println("▶ 비밀 번호 입력");
        String password = sc.next();
        System.out.println("▶ 전화 번호 입력");
        String phoneNumber = sc.next();
        System.out.println("> 이메일 입력하시오");
        String email = sc.next();
        return new MemberDto(0, name, userName, password, Role.INVENTORY, phoneNumber, email);

    }
}












