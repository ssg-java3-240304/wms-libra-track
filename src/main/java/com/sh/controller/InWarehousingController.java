package com.sh.controller;

import com.sh.model.entity.InWarehousing;
import com.sh.model.entity.Status;
import com.sh.model.service.InWarehousingService;
import com.sh.view.InWarehousingView;

import java.util.HashMap;
import java.util.List;

public class InWarehousingController {

    private InWarehousingService inWarehousingService;

    private InWarehousingView inWarehousingView;


    public void insertInWarehousing(HashMap<String, Integer> orders, String publisherManagerName) {

        inWarehousingService.insertInWarehousing(orders, publisherManagerName);
    }

    // 상태별 입고 내역 조회
    public List<InWarehousing> findInWarehousingByStatus(Status status) {
        List<InWarehousing> inWarehousingList = inWarehousingService.findInWarehousingByStatus(status);
        InWarehousingView.displayInWarehousing(inWarehousingList);
        return inWarehousingList;
    }

    public void updateInWarehousingStatus(int inWarehousingId, int inventoryManagerId, Status status) {
        inWarehousingService.updateInWarehousingStatus(inWarehousingId, inventoryManagerId, status);
    }

    // 출판사별 입고 내역 조회
    public List<InWarehousing> findByPublisherId(int publisherId) {
        List<InWarehousing> inWarehousingList = inWarehousingService.findInWarehousingByPublisher(publisherId);
        InWarehousingView.displayInWarehousing(inWarehousingList);
        return inWarehousingList;
    }
    // 출판사의 상태별 입고 내역 조회
    public List<InWarehousing> findByPublisherIdAndStatus(int publisherId, Status status) {
        List<InWarehousing> inWarehousingList = inWarehousingService.findInWarehousingByPublisherIdAndStatus(publisherId, status);
        InWarehousingView.displayInWarehousing(inWarehousingList);
        return inWarehousingList;
    }

    // 출판사 직원별 입고 내역 조회
    public List<InWarehousing> findByPublisherManager(int publisherManagerId) {
        List<InWarehousing> inWarehousingList = inWarehousingService.findInWarehousingByPublisherManagerId(publisherManagerId);
        InWarehousingView.displayInWarehousing(inWarehousingList);
        return inWarehousingList;
    }

    // 출판사 직원의 상태별 입고 내역 조회
    public List<InWarehousing> findByPublisherManagerAndStatus(int publisherManagerId, Status status) {
        List<InWarehousing> inWarehousingList = inWarehousingService.findInWarehousingByPublisherManagerIdAndStatus(publisherManagerId, status);
        InWarehousingView.displayInWarehousing(inWarehousingList);
        return inWarehousingList;
    }







}
