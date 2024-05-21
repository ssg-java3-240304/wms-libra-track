package com.sh.controller;

import com.sh.model.entity.ExWarehousing;
import com.sh.model.entity.Status;
import com.sh.model.service.ExWarehousingService;
import com.sh.view.ExWarehousingView;


import java.util.HashMap;
import java.util.List;

public class ExWarehousingController {
    private final ExWarehousingService exWarehousingService = new ExWarehousingService();

    //출고 요청
    public void insertExWarehousing(HashMap<String, Integer> orders, int publisherId, String address, String receiver, String receiverPhone, String receiverEmail ) {
        exWarehousingService.insertExWarehousing(orders, publisherId, address, receiver, receiverPhone, receiverEmail);
    }

    // 출고 상태 내역 조회
    public List<ExWarehousing> findExWarehousingByStatus(Status status) {
        List<ExWarehousing> exWarehousingList = exWarehousingService.findExWarehousingByStatus(status);
        ExWarehousingView.displayExWarehousing(exWarehousingList);
        return exWarehousingList;
    }

    // 출고 상태 업데이트
    public void updateExWarehousingStatus(int exWarehousingId, int inventoryManagerId, Status status) {
        exWarehousingService.updateExWarehousingStatus(exWarehousingId, inventoryManagerId, status);
    }

    // 출판사별 출고 내역 조회
    public List<ExWarehousing> findByPublisherId(int publisherId) {
        List<ExWarehousing> exWarehousingList = exWarehousingService.findExWarehousingByPublisher(publisherId);
        ExWarehousingView.displayExWarehousing(exWarehousingList);
        return exWarehousingList;
    }

    // 출판사 직원별 출고 내역 조회
    public List<ExWarehousing> findByPublisherManager(int publisherManagerId) {
        List<ExWarehousing> exWarehousingList = exWarehousingService.findExWarehousingByPublisherManagerId(publisherManagerId);
        ExWarehousingView.displayExWarehousing(exWarehousingList);
        return exWarehousingList;
    }

    // 출판사별 출고 상태 조회
    public List<ExWarehousing> findByPublisherIdAndStatus(int publisherId, Status status) {
        List<ExWarehousing> exWarehousingList = exWarehousingService.findExWarehousingByPublisherIdAndStatus(publisherId, status);
        ExWarehousingView.displayExWarehousing(exWarehousingList);
        return exWarehousingList;
    }

    // 출판사 직원별 출고 상태 조회
    public List<ExWarehousing> findByPublisherManagerAndStatus(int publisherManagerId, Status status) {
        List<ExWarehousing> exWarehousingList = exWarehousingService.findExWarehousingByPublisherManagerIdAndStatus(publisherManagerId, status);
        ExWarehousingView.displayExWarehousing(exWarehousingList);
        return exWarehousingList;
    }
}
