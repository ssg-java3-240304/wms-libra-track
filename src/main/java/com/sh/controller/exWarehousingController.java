package com.sh.controller;

import com.sh.model.entity.ExWarehousing;
import com.sh.model.entity.Status;
import com.sh.model.service.exWarehousingService;

import java.util.HashMap;
import java.util.List;

public class exWarehousingController {
    private exWarehousingService exWarehousingService;

    // 출고 요청
    public void save(ExWarehousing exWarehousing) {
        exWarehousingService.save();
    }

    // 출고 상태 조회
    public List<ExWarehousing> findExwarehousingByStatus(Status status) {
        return exWarehousingService.findExwarehousingByStatus(status);
    }

    // 출고 상태 업데이트
    public void updateExWarehousingStatus(int exWarehousingId, int inventoryManagerId, Status status) {
        // Todo
        exWarehousingService.updateExWarehousingStatus(exWarehousingId, inventoryManagerId, status);
    }

    // 출판사 매니저 아이디로 조회
    public List<ExWarehousing> findByPubManagerId() {
        // Todo
        return null;
    }

    // 창고매니저 아이디로 조회
    public List<ExWarehousing> findByInvenManagerId() {
        // Todo
        return null;
    }
}
