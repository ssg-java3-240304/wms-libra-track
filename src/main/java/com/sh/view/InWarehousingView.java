package com.sh.view;

import com.sh.controller.InWarehousingController;
import com.sh.controller.OrderController;
import com.sh.model.entity.InWarehousing;
import com.sh.model.entity.Status;
import lombok.*;

import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InWarehousingView {
    private  static List<Integer> ids = new ArrayList<>();

    private static Scanner scanner = new Scanner(System.in);

    private static String PUB_MANAGER = "publisherManager";
    private static Integer PUB_MANAGER_ID = 0;
    private static String PUB_NAME = "publisherName";
    private static Integer PUB_ID = 0;
    private static String INV_MANAGER = "inventory";

    private static OrderView orderView;

    public static InWarehousingController inWarehousingController = new InWarehousingController();

    public static OrderController orderController = new OrderController();

    public static void inWarehousingPublisherMenu() {
        String inWarehousingMenu = """
                📦📦📦 입고 관리 📦📦📦
                ======================
                1. 입고 정보 조회
                2. 입고 정보 등록
                0. 뒤로 가기
                ======================
                입력 : 
                """;
        while(true) {
            System.out.println(inWarehousingMenu);
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":

                    break;
                case "2":
                    inWarehousingRegister();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }

    public static void inWarehousingInventoryManagerMenu() {
        String inWarehousingMenu = """
                📦📦📦 입고 관리 📦📦📦
                ======================
                1. 입고 정보 조회
                0. 뒤로 가기
                ======================
                입력 : 
                """;
        System.out.println(inWarehousingMenu);
    }

    public static void inWarehousingRegister() {
        System.out.println("입고 정보를 등록합니다.");
        HashMap<String, Integer> orders = new HashMap<>();

        while(true) {
            System.out.println("도서 ISBN 번호를 입력해주세요. (exit 입력시 종료)");
            String isbn = scanner.nextLine();
            if(Objects.equals(isbn, "exit")) {
                break;
            }
            System.out.println("도서 입고 수량을 입력해주세요.");
            int quantity = Integer.parseInt(scanner.nextLine());
            orders.put(isbn, quantity);
        }

        inWarehousingController.insertInWarehousing(orders, PUB_MANAGER);

        System.out.println("입고 정보 등록이 완료되었습니다.");

    }

    public static void inWarehousingRead() {
        System.out.println("입고 정보를 조회합니다.");

        String readMenu = """
                📦📦📦 입고 정보 조회 📦📦📦
                ======================
                1. 출판사 전체 입고 정보 조회
                2. 출판사 입고 상태별 입고 정보 조회
                3. 나의 전체 입고 정보 조회
                4. 나의 입고 상태별 입고 정보 조회
                0. 뒤로 가기
                ======================
                입력 : 
                """;

        while(true) {
            System.out.println(readMenu);
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    inWarehousingController.findByPublisherId(PUB_ID);
                    break;
                case "2":
                    inWarehousingController.findByPublisherIdAndStatus(PUB_ID, Status.valueOf(scanner.nextLine()));
                    break;
                case "3":
                    inWarehousingController.findByPublisherManager(PUB_MANAGER_ID);
                    break;
                case "4":
                    inWarehousingController.findByPublisherManagerAndStatus(PUB_MANAGER_ID, Status.valueOf(scanner.nextLine()));
                    break;
                case "0":
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }


    }





    public static void displayInWarehousing(List<InWarehousing> inWarehousing) {

        if (inWarehousing.isEmpty()) {
            System.out.println("입고 정보가 없습니다.");
        } else {
            System.out.println("-----------------------------------------------");
            System.out.printf("%s\t%s\t%s\t%s\t%s\n", "InWarehousingId", "Date", "Status", "Publisher Manager Id", "Inventory Manager Id");
            System.out.println("-----------------------------------------------");
            for(InWarehousing iw : inWarehousing) {
                ids.clear();
                ids.add(iw.getInWarehousingId());
                System.out.printf("%d\t%s\t%s\t%d\t%d\n",
                        iw.getInWarehousingId(),
                        iw.getDate(),
                        iw.getStatus(),
                        iw.getPublisherManagerId(),
                        iw.getInventoryManagerId()
                );
            }
            System.out.println("-----------------------------------------------");

        }
        OrderView.orderMenu(ids);
    }


}
