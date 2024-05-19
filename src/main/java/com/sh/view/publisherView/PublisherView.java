package com.sh.view.publisherView;

import com.sh.controller.publisher.PublisherController;
import com.sh.model.dto.publishserDto.Publisher;
import com.sh.model.dto.publishserDto.PublisherManager;
import com.sh.view.bookView.BookMenuView;

import java.util.Scanner;

/**
 * 신규 출판사 등록
 * 출판사 정보 수정
 * 출판 정보 삭제
 * 출판사 정보 조회
 */
public class PublisherView
{
    PublisherController publisherController = new PublisherController();
    BookMenuView bookMenuView = new BookMenuView();
    Scanner scanner = new Scanner(System.in);

    PublisherManager publisherManager;

    /**
     * 아이디 , 비밀번호 로그인하고 , 해당 로그인된 정보에 따라서 출판사의 정보 가져오게 해야될거 같은데
     */
    public void startMenu(PublisherManager publisherManager){
        this.publisherManager = publisherManager;
        String menu = """
          1.출판 관리 
          2.출판사 관리
          0. 종료 
          """;
        System.out.println(menu);
        int n = scanner.nextInt();
        while (true) {
            switch (n) {
                case 1 : bookMenuView.showMenu(publisherManager);
                    break;
                case 2 : publisherMenu();
                    break;
                case 0 :
                    break;
                default : return;
            }
        }
    }
    public void publisherMenu() {
        String menu = """
                ======================
                1. 신규출판사 등록 
                2. 출판사 정보 수정 
                3. 출판사 정보 삭제 
                4. 출판사 정보 조회
                ======================
                """;
        while (true) {
            System.out.println(menu);
            System.out.println("원하시는 메뉴를 선택해주세요!");
            System.out.print("메뉴 : ");
            int n = scanner.nextInt();
            switch(n) {
                case 1 : publisherController.insertPublisher(input());//출판사 등록
                    break;
                case 2 : // publisherController.updatePublisher(updateinput());//출판사 정보 수정
                    break;
                case 3 : //출판사 삭제
                    break;
                case 4 : //출판사 정보 조회
                    break;

            }

        }
    }

    private Publisher input() {
        System.out.println("=======================");
        System.out.print("출판사 정보 입력 : ");
        String publishName = scanner.next();
        System.out.print("이메일 입력 ");
        String email = scanner.next();
        System.out.print("휴대폰 번호 : ");
        String phoneNumber = scanner.next();
        System.out.print("사업자 번호 : ");
        String businessNumber = scanner.next();
        System.out.println("=======================");
        return new Publisher(0, publishName, email, phoneNumber, businessNumber);
    }
}
