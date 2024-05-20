package com.sh.view;

import com.sh.controller.OrderController;
import com.sh.model.dto.OrderDto;
import com.sh.model.entity.InWarehousing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderView {

    private static final OrderController orderController = new OrderController();

    private static final List<Integer> ids = new ArrayList<>();

    private static final Scanner scanner = new Scanner(System.in);

    public static void orderDetailMenu() {
        String menu = """
                ======================
                1. 입고 완료된 주문 상세 조회
                0. 뒤로 가기
                ======================
                입력 : 
                """;
        while(true) {
            System.out.println(menu);
            String choice = OrderView.scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.printf("입고 정보 ID를 입력해주세요. (입고 정보 ID : %s)\n", ids);
                    orderController.findOrderAreaDetailByOrderId(ids.get(Integer.parseInt(scanner.nextLine())));
                    break;
                case "0":
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }

    public static void orderMenu(List<Integer> ids) {
        System.out.println("입고 상세 정보를 조회합니다.");

        String readMenu = """
                📦📦📦 입고 정보 상세 조회 📦📦📦
                ======================
                1. 입고 정보 상세 조회
                0. 뒤로 가기
                ======================
                입력 : 
                """;

        while(true) {
            System.out.println(readMenu);
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.printf("입고 정보 ID를 입력해주세요. (입고 정보 ID : %s)\n", ids);
                    orderController.findOrderByInWarehousingId(ids.get(Integer.parseInt(scanner.nextLine())));
                    break;
                case "0":
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }
    public static void displayOrderDto(List<OrderDto> orderList) {
        if (orderList.isEmpty()) {
            System.out.println("입고 주문 정보가 없습니다.");
        } else {
            System.out.println("-----------------------------------------------");
            System.out.printf("%s\t%s\t%s\t%s\t%s\n", "Order Id", "title", "author", "ISBN", "quantity");
            System.out.println("-----------------------------------------------");
            for(OrderDto order : orderList) {
                ids.clear();
                ids.add(order.getOrderId());
                System.out.printf("%d\t%s\t%s\t%s\t%d\n",
                        order.getOrderId(),
                        order.getTitle(),
                        order.getAuthor(),
                        order.getISBN(),
                        order.getQuantity()
                );
            }
            System.out.println("-----------------------------------------------");
            orderDetailMenu();
        }


    }


}
