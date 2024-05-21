package com.sh.view.bookView.bookResultView;


import com.sh.model.dto.bookDto.Book;

import java.util.List;

public class DisplayResultView {
    public static void displayResult(String type, int result) {
        if (result > 0) {
            System.out.println("📖책이 성공적으로 " + type + "되었습니다 !");
        } else {
            System.out.println("책을 "+type+"하지 못하였습니다. 책의 정보 또는 ISBN정보를 다시 입력해주세요 ");
        }
    }

    public static void displayBook(Book book) {
        if (book == null) {
            System.out.println("해당 ISBN에 맞는 책이 없습니다.");
        }

        else{
            System.out.println("찾으신 책의 정보입니다 !😃");
            System.out.println("-------------------------");
            System.out.println("BookID : " + book.getBookId());
            System.out.println("BookName : " + book.getTitle());
            System.out.println("BookISBN: " + book.getISBN());
            System.out.println("PulisherId : " + book.getPublisherId());
            System.out.println("PubDate : " + book.getPubDate());
            System.out.println("Price : " + book.getPrice());
            System.out.println("Author : " + book.getAuthor());
            System.out.println("Pages : " + book.getPages());
            System.out.println("Size : " + book.getSize());
            System.out.println("GenreId : " + book.getGenreId());
            System.out.println("-------------------------");
        }
    }

    public static void displayBookList(List<Book> bookList) {
        if(bookList.isEmpty()){
            System.out.println("출판등록된 책이 없습니다.🙃");
        }
        else{
            System.out.printf("%-20s%-15s%-10s%-25s%-15s%-10s%-10s%n",
                    "책 제목", "책 ISBN", "가격", "출판일", "저자", "페이지 수", "크기");
            System.out.println("----------------------------------------------------------------------------------------------------------");
            for (Book book : bookList) {
                System.out.printf("%-20s%-15s%-10d%-25s%-15s%-10d%-10s%n",
                        book.getTitle(),
                        book.getISBN(),
                        book.getPrice(),
                        book.getPubDate(),
                        book.getAuthor(),
                        book.getPages(),
                        book.getSize()
                );
            }
        }

    }
}
