package com.sh.view;

import com.sh.model.entity.MemberDto;
import com.sh.model.entity.Role;

import java.util.Scanner;

public class PublisherManagerView {
    Scanner scanner = new Scanner(System.in);


    public void registerPmng() {
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
        new MemberDto(0, name, userName, password, Role.PUBLISHER, phoneNumber, email);
    }
}
