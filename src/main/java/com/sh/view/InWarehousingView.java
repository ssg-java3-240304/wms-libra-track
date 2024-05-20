package com.sh.view;

import com.sh.controller.InWarehousingController;
import com.sh.controller.OrderController;
import com.sh.model.entity.InWarehousing;
import com.sh.model.entity.Status;
import lombok.*;

import java.util.*;

@Getter
@Setter
public class InWarehousingView {
    private  static List<Integer> ids = new ArrayList<>();

    private static Scanner scanner = new Scanner(System.in);

    public static String PUB_MANAGER = "publisherManager";
    public static Integer PUB_MANAGER_ID = 0;
    public static String PUB_NAME = "publisherName";
    public static Integer PUB_ID = 0;
    public static Integer INVEN_MANAGER_ID  = 0;

    private static OrderView orderView;

    public static InWarehousingController inWarehousingController = new InWarehousingController();

    public static OrderController orderController = new OrderController();

    // 출판사 직원 메뉴
    public static void inWarehousingPublisherMenu() {
        String inWarehousingMenu = """
                📦📦📦 입고 관리 📦📦📦
                ======================
                1. 입고 정보 조회
                2. 입고 정보 등록(요청)
                0. 뒤로 가기
                ======================
                입력 : 
                """;
        while(true) {
            System.out.println(inWarehousingMenu);
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    inWarehousingRead();
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

        inWarehousingController.insertInWarehousing(orders, PUB_MANAGER_ID);

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
        ids.clear();
        if (inWarehousing.isEmpty()) {
            System.out.println("입고 정보가 없습니다.");
        } else {
            System.out.println("-----------------------------------------------");
            System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\n", "idx", "InWarehousingId", "Date", "Status", "Publisher Manager Id", "Inventory Manager Id");
            System.out.println("-----------------------------------------------");
            int idx = 1;
            for(InWarehousing iw : inWarehousing) {
                ids.add(iw.getInWarehousingId());
                System.out.printf("%d\t%d\t%s\t%s\t%d\t%d\n",
                        idx,
                        iw.getInWarehousingId(),
                        iw.getDate(),
                        iw.getStatus(),
                        iw.getPublisherManagerId(),
                        iw.getInventoryManagerId()
                );
                idx += 1;
            }
            System.out.println("-----------------------------------------------");

            if(PUB_MANAGER_ID != 0) {
                inWarehousingPublisherReadMenu();
            } else {
                inWarehousingInventoryManagerReadMenu();
            }
        }
    }
    public static void inWarehousingPublisherReadMenu() {

        System.out.println("입고 상세 정보를 조회합니다.");

        String menu = """
                📦📦📦 입고 정보 상세 조회 📦📦📦
                ======================
                1. 입고 정보 상세 조회
                0. 뒤로 가기
                ======================
                입력 : 
                """;

        while(true) {
            System.out.println(menu);
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.printf("입고 정보 ID를 입력해주세요. (입고 정보 ID : %s)\n", ids);
                    orderController.findOrderByInWarehousingId(ids.get(Integer.parseInt(scanner.nextLine()) - 1));
                    break;
                case "0":
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }

        }
    }

    public static Scanner getScanner() {
        return scanner;
    }

    // 입고 관리자 메뉴
    public static void inWarehousingInventoryManagerMainMenu() {
        String inWarehousingMenu = """
                📦📦📦 입고 관리 📦📦📦
                ======================
                1. 입고 상태별 조회
                0. 뒤로 가기
                ======================
                입력 : 
                """;
        while(true) {
            System.out.println(inWarehousingMenu);
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    // 잘못 선택된 status 입력시 재입력
                    System.out.println("입고 상태를 입력해주세요. (PENDING, ACCEPTED, REJECTED, COMPLETED)");
                    Status status;
                    try {
                        status = Status.valueOf(scanner.nextLine());
                    } catch (Exception exception) {
                        System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                        break;
                    }
                    inWarehousingController.findInWarehousingByStatus(status);
                    break;
                case "0":
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }

    public static void inWarehousingInventoryManagerReadMenu() {
        String inWarehousingMenu = """
                📦📦📦 입고 내역 관리 📦📦📦
                ======================
                1. 입고 정보 상세 조회
                2. 입고 상태 변경
                0. 뒤로 가기
                ======================
                입력 : 
                """;
        while(true) {
            System.out.println(inWarehousingMenu);
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.printf("입고 정보 ID를 입력해주세요. (입고 정보 ID : %s)\n", ids);
                    orderController.findOrderByInWarehousingId(ids.get(Integer.parseInt(scanner.nextLine()) - 1));
                    break;
                case "2":
                    System.out.printf("입고 정보 ID를 입력해주세요. (입고 정보 ID : %s)\n", ids);
                    System.out.println("입고 상태를 입력해주세요. (ACCEPTED, REJECTED, COMPLETED)");
                    Status status;
                    try {
                        status = Status.valueOf(scanner.nextLine());
                    } catch (Exception exception) {
                        System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                        break;
                    }
                    inWarehousingController.updateInWarehousingStatus(ids.get(Integer.parseInt(scanner.nextLine()) - 1), INVEN_MANAGER_ID, status);
                    break;
                case "0":
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }

    }

}
