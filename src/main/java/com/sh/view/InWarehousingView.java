package com.sh.view;

import com.sh.model.entity.InWarehousing;

import java.util.List;

public class InWarehousingView {

    public static void displayInWarehousing(List<InWarehousing> inWarehousing) {

        if (inWarehousing.isEmpty()) {
            System.out.println("입고 정보가 없습니다.");
        } else {
            System.out.println("-----------------------------------------------");
            System.out.printf("%s\t%s\t%s\t%s\t%s\n", "InWarehousingId", "Date", "Status", "Publisher Manager Id", "Inventory Manager Id");
            System.out.println("-----------------------------------------------");
            for(InWarehousing iw : inWarehousing) {
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
    }


}
