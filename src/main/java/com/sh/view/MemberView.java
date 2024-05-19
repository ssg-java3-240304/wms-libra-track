package com.sh.view;

import com.sh.common.Role;
import com.sh.controller.MemberController;
import com.sh.model.dto.MemberDTO;
import com.sh.model.dto.publishserDto.PublisherManager;
import com.sh.view.publisherView.PublisherView;

import java.util.Scanner;

/**
 * 로그인 -> PubisherView를 보여줘야되는데 여기서 Publisher의 정보를 줘야겠지 로그인정보에 따라서
 * publisherView를 보여줄때 Pulbisher에게 PublisherManager의 정보 전달 생성자로
 *
 * Member와 publisherManager는 pulibsher_id로 연관되어있다.
 */
public class MemberView {
    PublisherManager pulisherManager = new PublisherManager(1,1);

    PublisherManager publisherManager = new PublisherManager();
    PublisherView publisherView = new PublisherView();
    public void start() {
        publisherView.startMenu(publisherManager);
    }

}

//MemberDTO memberDTO = new MemberDTO();
//MemberController memberController = new MemberController();
//Scanner scanner = new Scanner(System.in);
//public void loginMenu(){
//    while(true)
//    {
//        String loginMenu = """
//                    1. 로그인
//                    2. 회원가입
//                    0. 종료
//                    """;
//        System.out.println(loginMenu);
//        System.out.print("메뉴 선택 : ");
//        int num = scanner.nextInt();
//        switch (num) {
//            case 1:
//                memberController.logIn(inputIdAndPassword());
//                break;
//            case 2:
//                memberController.join(inputInformation());
//        }
//    }
//}

//private  MemberDTO inputInformation() {
//    System.out.print("이름 입력 : ");
//    String name = scanner.next();
//    System.out.print("사용할 아이디 : ");
//    String id = scanner.next();
//    System.out.print("비밀번호 입력 : ");
//    String password = scanner.next();
//    System.out.print("ROLE : 창고관리자, 출판사");
//    String roleName = scanner.next();
//    Role role = Role.valueOf(roleName);
//    System.out.print("휴대폰 번호 : ");
//    String phoneNumber = scanner.next();
//    System.out.print("이메일  : ");
//    String email = scanner.next();
//    return new MemberDTO(0, name, id, password, role, phoneNumber, email);
//}
//public Object inputIdAndPassword()
//{
//    return null;
//}
