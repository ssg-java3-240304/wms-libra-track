package com.sh.model.entity;



public class InventoryManagerDto {




    private int inventoryManagerId;
    private int empNumber;
    private String entryDate;
    private int inventoryId;


    public InventoryManagerDto() {
    }

    public InventoryManagerDto(int inventoryManagerId, int empNumber, String entryDate, int inventoryId) {
        this.inventoryManagerId = inventoryManagerId;
        this.empNumber = empNumber;
        this.entryDate = entryDate;
        this.inventoryId = inventoryId;
    }

    public int getInventoryManagerId() {
        return inventoryManagerId;
    }

    public void setInventoryManagerId(int inventoryManagerId) {
        this.inventoryManagerId = inventoryManagerId;
    }

    public int getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(int empNumber) {
        this.empNumber = empNumber;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    @Override
    public String toString() {
        return "InventoryManagerDto{" +
                "inventoryManagerId=" + inventoryManagerId +
                ", empNumber=" + empNumber +
                ", entryDate='" + entryDate + '\'' +
                ", inventoryId=" + inventoryId +
                '}';
    }
}
