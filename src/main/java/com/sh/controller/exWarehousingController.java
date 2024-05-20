package com.sh.controller;

import com.sh.model.entity.ExWarehousing;
import com.sh.model.entity.Status;
import com.sh.model.service.exWarehousingService;

import java.util.HashMap;
import java.util.List;

public class exWarehousingController {
    private exWarehousingService exWarehousingService;

    // 출고 요청
//    public void save(ExWarehousing exWarehousing) {
//        // Todo
//        exWarehousingService.save();
//    }

    // 출고 상태 내역 조회
    public List<ExWarehousing> findExWarehousingByStatus(Status status) {
        return exWarehousingService.findExWarehousingByStatus(status);
    }

    // 출고 상태 업데이트
    public void updateExWarehousingStatus(int exWarehousingId, int inventoryManagerId, Status status) {
        exWarehousingService.updateExWarehousingStatus(exWarehousingId, inventoryManagerId, status);
    }

    // 출판사별 출고 내역 조회
    public List<ExWarehousing> findByPublisherId(int publisherId) {
        return exWarehousingService.findExWarehousingByPublisher(publisherId);
    }

    // 출판사 직원별 출고 내역 조회
    public List<ExWarehousing> findByPublisherManager(int publisherManagerId) {
        return exWarehousingService.findExWarehousingByPublisherManagerId(publisherManagerId);
    }

    // 출판사별 출고 상태 조회
    public List<ExWarehousing> findByPublisherIdAndStatus(int publisherId, Status status) {
        return exWarehousingService.findExWarehousingByPublisherIdAndStatus(publisherId, status);
    }

    // 출판사 직원별 출고 상태 조회
    public List<ExWarehousing> findByPublisherManagerAndStatus(int publisherManagerId, Status status) {
        return exWarehousingService.findExWarehousingByPublisherManagerIdAndStatus(publisherManagerId, status);
    }
}
