package com.sh.controller;

import com.sh.model.entity.InWarehousing;
import com.sh.model.entity.Order;
import com.sh.model.entity.Status;
import com.sh.model.service.InWarehousingService;

import java.util.HashMap;
import java.util.List;

public class InWarehousingController {

    private InWarehousingService inWarehousingService;


    public void insertInWarehousing(HashMap<String, Integer> orders, String publisherName) {

        inWarehousingService.insertInWarehousing(orders, publisherName);
    }


    public List<InWarehousing> findInWarehousingByStatus(Status status) {
        return inWarehousingService.findInWarehousingByStatus(status);
    }


}
