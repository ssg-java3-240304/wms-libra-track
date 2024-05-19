package com.sh.view;

import com.sh.controller.MemberController;
import com.sh.controller.PublisherManagerController;
import com.sh.model.entity.MemberDto;
import com.sh.model.entity.PublisherManagerDto;
import com.sh.model.entity.Role;
import com.sh.model.service.PublisherManagerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Flow;

public class MemberView {


    private Scanner sc = new Scanner(System.in);
    private MemberController memberController = new MemberController();
    private PublisherManagerService publisherManagerService = new PublisherManagerService();

    public void mainMenu() {
        String menu = """
                ======================
                1. 회원 가입
                2. 로그인
                0. 종료
                ======================
                입력 : 
                """;

        while (true) {
            System.out.print(menu);
            String choice = sc.next();
            switch (choice) {
                case "1":
                    choiceMenu();
//                    memberController.addMember(addMember());
                    break;
                case "2":
                    loginCheck();
                    break;
            }
        }
    }

    private void loginCheck() {
        System.out.println("아이디 입력 : ");
        String id = sc.next();
        System.out.println("비밀번호 입력 : ");
        String password = sc.next();
        MemberDto member =  memberController.loginCheck(id, password);
    }


    private void choiceMenu() {
        String choiceMenu = """
                
                ✅ 회원 선택을 해주세요✅
                ======================
                1. 출판사 매니저
                2. 창고 관리자
                ======================
                """;
        while (true) {
            System.out.print(choiceMenu);
            String choice = sc.next();
            switch (choice) {
                case "1" :
                    System.out.println("🆘🆘🆘출판사를 선택하는 메소드 가져와야함!!!🆘🆘🆘");
                    memberController.addMember(addMember());
                    break;
            }
        }
    }

    private MemberDto addMember() {
        System.out.println("> ✏✏✏ 회원 등록할 정보 작성해주세요. ✏✏✏");
        System.out.print("> 회원 이름 입력 : ");
        String name = sc.next();
        sc.nextLine();
        System.out.print("> username 입력 : ");
        String userName = sc.next();
        sc.nextLine();
        System.out.print("> 비밀 번호 입력 : ");
        String password = sc.nextLine();
        System.out.print("> 전화 번호 입력 : ");
        String phoneNumber = sc.nextLine();
        System.out.print("> 이메일 입력 : ");
        String email = sc.nextLine();
        return new MemberDto(0, name, userName, password, Role.PUBLISHER,phoneNumber, email);
    }
}












