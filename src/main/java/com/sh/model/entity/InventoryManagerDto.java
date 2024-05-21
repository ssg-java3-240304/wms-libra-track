package com.sh.model.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class InventoryManagerDto {

    private int inventoryManagerId;
    private Timestamp entryDate;
    private int empNumber;
    private int inventoryId;
    private int memberId;
    private MemberDto memberDto;

    public InventoryManagerDto(Timestamp entryDate, int empNumber ,int inventoryId, int memberId) {
        this.entryDate = entryDate;
        this.empNumber = empNumber;
        this.inventoryId = inventoryId;
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        return "InventoryManagerDto{" +
                "inventoryManagerId=" + inventoryManagerId +
                ", entryDate=" + entryDate +
                ", empNumber=" + empNumber +
                ", inventoryId=" + inventoryId +
                ", memberId=" + memberId +
                ", memberDto=" + memberDto +
                '}';
    }
}


