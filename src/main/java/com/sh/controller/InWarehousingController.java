//package com.sh.controller;
//
//import com.sh.model.entity.InWarehousing;
//import com.sh.model.entity.Order;
//import com.sh.model.entity.Status;
//import com.sh.model.service.InWarehousingService;
//
//import java.util.HashMap;
//import java.util.List;
//
//public class InWarehousingController {
//
//    private InWarehousingService inWarehousingService;
//
//
//    // 입고 요청
//    public void insertInWarehousing(HashMap<String, Integer> orders, String publisherName) {
//
//        inWarehousingService.insertInWarehousing(orders, publisherName);
//    }
//
//    // 입고 상태에 따른 조회
//
//    public List<InWarehousing> findInWarehousingByStatus(Status status) {
//        return inWarehousingService.findInWarehousingByStatus(status);
//    }
//
//
//}
