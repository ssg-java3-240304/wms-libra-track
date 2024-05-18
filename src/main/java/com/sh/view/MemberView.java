package com.sh.view;

import com.sh.controller.MemberController;
import com.sh.model.entity.MemberDto;
import com.sh.model.entity.Role;

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
            System.out.println(menu);
            String choice = scanner.next();
            switch (choice) {
                case "1":
                    memberController.addMember(addMember());



            }
        }
    }

    private MemberDto addMember() {
        System.out.println("> ✏✏✏ 회원 등록할 정보 작성해주세요. ✏✏✏");
        System.out.println("> 회원 이름 입력");
        String name = scanner.next();
        scanner.nextLine();
        System.out.println("> username 입력");
        String userName = scanner.next();
        scanner.nextLine();
        System.out.println("> 비밀 번호 입력");
        String password = scanner.nextLine();
        System.out.println("> PUBLISHER OR INVENTORY_MANAGER?");
        String roleInput = scanner.nextLine();
        Role role = Role.valueOf(roleInput.toUpperCase());
        System.out.println("> 전화 번호 입력");
        String phoneNumber = scanner.nextLine();
        System.out.println("> 이메일 입력하시오");
        String email = scanner.nextLine();
        return new MemberDto(0,name, userName, password, role ,phoneNumber,email);

    }
}
