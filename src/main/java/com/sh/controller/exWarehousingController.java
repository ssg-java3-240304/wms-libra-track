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

    // 출고 상태 조회
    public List<ExWarehousing> findExWarehousingByStatus(Status status) {
        return exWarehousingService.findExWarehousingByStatus(status);
    }

    // 출고 상태 업데이트
    public void updateExWarehousingStatus(int exWarehousingId, int inventoryManagerId, Status status) {
        exWarehousingService.updateExWarehousingStatus(exWarehousingId, inventoryManagerId, status);
    }

    // 출판사별 출고 조회
    public List<ExWarehousing> findByPublisherId(int publisherId) {
        return exWarehousingService.findExWarehousingByPublisher(publisherId);
    }

    // 창고매니저 아이디로 조회
    public List<ExWarehousing> findByInventoryManagerId() {
        // Todo
        return null;
    }
}
