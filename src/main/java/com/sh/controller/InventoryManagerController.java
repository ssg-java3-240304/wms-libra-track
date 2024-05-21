package com.sh.controller;


import com.sh.model.entity.InventoryManagerDto;
import com.sh.model.entity.MemberDto;
import com.sh.model.entity.PublisherManagerDto;
import com.sh.model.service.InventoryManagerService;
import com.sh.view.MemberResultView;

import java.util.List;


public class InventoryManagerController {
    private InventoryManagerService inventoryManagerService = new InventoryManagerService();

    public InventoryManagerDto findPublisherManagerInfo(MemberDto memberDto) {
        InventoryManagerDto inventoryManagerDto = inventoryManagerService.findInventorymanager(memberDto);

        return inventoryManagerDto;
    }

}