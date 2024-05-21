package com.sh.controller;


import com.sh.model.entity.InventoryManagerDto;
import com.sh.model.entity.MemberDto;
import com.sh.model.service.InventoryManagerService;


public class InventoryManagerController {
    private InventoryManagerService inventoryManagerService = new InventoryManagerService();


    public InventoryManagerDto findAll(int memberId){
        return inventoryManagerService.findAll(memberId);
    }

    public void updateId(MemberDto memberDto) {
       int result =  inventoryManagerService.updateId(memberDto);
    }

    public void updatePassword(MemberDto updatedPassword) {
        int result = inventoryManagerService.updatePassword(updatedPassword);
    }

    public void updatePhoneNumber(MemberDto updatedPhoneNumber) {
        int result = inventoryManagerService.updatePhoneNumber(updatedPhoneNumber);
    }
}