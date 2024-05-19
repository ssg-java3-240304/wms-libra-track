package com.sh.view;

import com.sh.controller.MemberController;
import com.sh.controller.PublisherManagerController;
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

        while (true) {
            System.out.print(menu);
            String choice = scanner.next();
            switch (choice) {
                case "1":
                    choiceMenu();
                    memberController.addMember(addMember());
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
            System.out.print(choiceMenu);
            String choice = scanner.next();
            switch (choice) {
                case "1" :
                     memberController.addMember(addMember());
//                    publisherManagerController.registerPublisherManager();
                    break;
            }
        }
    }

    private MemberDto addMember() {
        System.out.println("> ✏✏✏ 회원 등록할 정보 작성해주세요. ✏✏✏");
        System.out.print("> 회원 이름 입력 : ");
        String name = scanner.next();
        scanner.nextLine();
        System.out.print("> username 입력 : ");
        String userName = scanner.next();
        scanner.nextLine();
        System.out.print("> 비밀 번호 입력 : ");
        String password = scanner.nextLine();
        System.out.print("> 전화 번호 입력 : ");
        String phoneNumber = scanner.nextLine();
        System.out.print("> 이메일 입력 : ");
        String email = scanner.nextLine();
        return new MemberDto(0, name, userName, password, phoneNumber, email);
    }
}












