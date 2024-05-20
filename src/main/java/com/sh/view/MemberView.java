package com.sh.view;

import com.sh.controller.InventoryManagerController;
import com.sh.controller.MemberController;
import com.sh.controller.PublisherManagerController;
import com.sh.model.entity.InventoryManagerDto;
import com.sh.model.entity.MemberDto;
import com.sh.model.entity.PublisherManagerDto;
import com.sh.model.entity.Role;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberView {


    private Scanner scanner = new Scanner(System.in);
    private MemberController memberController = new MemberController();

    public void mainMenu() {
        String menu = """
                ======================
                1. 회원 가입
                2. 로그인
                0. 종료
                ======================
                입력 : 
                """;
// view 에다가 static 처럼 저장을 해둬라 (로그인)!!
        while (true) {
            System.out.println(menu);
            String choice = scanner.next();
            switch (choice) {
                case "1":
                    choiceMenu(); // 이걸 이름 바꿔서 사용
//                    memberController.addMember(addMember()); - 이거 없어도 됨
                    break;
            }
        }
    }

    private void choiceMenu() {
        String choiceMenu = """
                ====================
                회원 선택을 해주세요
                ====================
                1. 출판사 매니저
                2. 창고 관리자
                ====================
                """;
        while (true) {
            System.out.println(choiceMenu);
            String choice = scanner.next();
            switch (choice) {
                case "1" :
                     memberController.addMember(addMember());

                    break;

                case "2" :
                    memberController.addInventoryManager(inventoryAddMember());

                    break;
            }
        }
    }

    // Publisher 회원가입
    private MemberDto addMember()
    {
        System.out.println("> ✏✏✏ 회원 등록할 정보 작성해주세요. ✏✏✏");
        System.out.println("> 회원 이름 입력");
        String name = scanner.next();
        scanner.nextLine();
        System.out.println("> username 입력");
        String userName = scanner.next();
        scanner.nextLine();
        System.out.println("> 비밀 번호 입력");
        String password = scanner.nextLine();
        System.out.println("> 전화 번호 입력");
        String phoneNumber = scanner.nextLine();
        System.out.println("> 이메일 입력하시오");
        String email = scanner.nextLine();
        return new MemberDto(0,name, userName, password, Role.PUBLISHER ,phoneNumber,email);
    }

    //InventoryManager 회원가입
    private MemberDto inventoryAddMember() {
        System.out.println("> ✏✏✏ 회원 등록할 정보 작성해주세요. ✏✏✏");
        System.out.println("> 회원 이름 입력");
        String name = scanner.next();
        scanner.nextLine();
        System.out.println("> username 입력");
        String userName = scanner.next();
        scanner.nextLine();
        System.out.println("> 비밀 번호 입력");
        String password = scanner.nextLine();
        System.out.println("> 전화 번호 입력");
        String phoneNumber = scanner.nextLine();
        System.out.println("> 이메일 입력하시오");
        String email = scanner.nextLine();
        return new MemberDto(0,name, userName, password, Role.INVENTORY ,phoneNumber,email);
    }



}












