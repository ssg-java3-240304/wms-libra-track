package com.sh.controller;

import com.sh.model.entity.InWarehousing;
import com.sh.model.entity.Status;
import com.sh.model.service.InWarehousingService;

import java.util.HashMap;
import java.util.List;

public class InWarehousingController {

    private InWarehousingService inWarehousingService;


    public void insertInWarehousing(HashMap<String, Integer> orders, String publisherName) {

        inWarehousingService.insertInWarehousing(orders, publisherName);
    }

    // 상태별 입고 내역 조회
    public List<InWarehousing> findInWarehousingByStatus(Status status) {
        return inWarehousingService.findInWarehousingByStatus(status);
    }

    public void updateInWarehousingStatus(int inWarehousingId, Status status) {
        inWarehousingService.updateInWarehousingStatus(inWarehousingId, status);
    }

    // 출판사별 입고 내역 조회
    public List<InWarehousing> findInWarehousingByPublisher(String publisherName) {
        return inWarehousingService.findInWarehousingByPublisher(publisherName);
    }






}
