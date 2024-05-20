package com.sh.controller;

import com.sh.model.entity.ExWarehousing;
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
    public List<ExWarehousing> findByStatus(Enum status) {
        // Todo
        return null;
    }

    // 업데이트
    public void update(ExWarehousing exWarehousing) {
        // Todo
    }

    //
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
