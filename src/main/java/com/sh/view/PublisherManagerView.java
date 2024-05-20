package com.sh.view;

import com.sh.controller.PublisherManagerController;
import com.sh.model.entity.MemberDto;
import com.sh.model.entity.PublisherManagerDto;
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

    public void choicePublisherMenu(int memberId) {
        String choicePublisherMenu = """
                📖📖📖출판사 매니저 메뉴📖📖📖
                =============================
                1. 회원 정보 관리
                2. 도서 관리
                3. 입/출고 관리
                =============================
                입력 : 
                """;
        while (true) {
            System.out.println(choicePublisherMenu);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    publisherManagement(memberId);
//            case 2 : BookView.(); break;
//            case 3 : InventoryView(); break;
                default:
                    System.out.print("잘못된 입력입니다. 다시 입력해주세요 : ");
                    ;
            }
        }
    }

    private void publisherManagement(int memberId) {
        String publihserManagement = ("""
                ===================
                ℹ️ 회원 정보 관리 ℹ️
                ===================
                 1. 회원 정보 조회
                 2. 회원 정보 수정
                 3. 회원 정보 삭제
                ===================
                """);
        while (true) {
            System.out.println(publihserManagement);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    publisherManagerController.findPublisherManagerInfo(memberId);
                    break;
                case 2:
                    publisherManagerController.updatePublisherManager(memberId); break;
                case 3:
//                    publisherManagerController.deletePublisherManager(); break;
            }
        }
    }

    public static void displayPublisherManager(PublisherManagerDto publisherManagerDto) {
        if (publisherManagerDto == null)System.out.println("조회되지 않는 회원 정보입니다.");
        System.out.printf(
                "1. 회원 ID : %d \n" +
                "2. 이름 :  %s \n" +
                "3. 아이디 : %s \n" +
                "4. 비밀 번호 :  %s \n" +
                "5. 구분 : %s \n" +
                "6. 개인 핸드폰 : %s \n" +
                "7. 이메일주소 : %s \n" +
                "8. 출판사 매니저 ID : %s \n" +
                "9. 출판사 ID : %s \n",
                publisherManagerDto.getMemberDto().getMemberId(),
                publisherManagerDto.getMemberDto().getName(),
                publisherManagerDto.getMemberDto().getUserName(),
                publisherManagerDto.getMemberDto().getPassword(),
                publisherManagerDto.getMemberDto().getRole(),
                publisherManagerDto.getMemberDto().getPhoneNumber(),
                publisherManagerDto.getMemberDto().getEmail(),
                publisherManagerDto.getPublisherManagerId(),
                publisherManagerDto.getPublisherId()
                );
    }

}
//홍지민 작업 끝
