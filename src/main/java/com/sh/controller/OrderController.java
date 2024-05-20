package com.sh.controller;

import com.sh.model.dto.OrderAreaDetailDto;
import com.sh.model.dto.OrderDto;
import com.sh.model.service.BookAreaService;
import com.sh.model.service.OrderAreaService;
import com.sh.model.service.OrderService;
import com.sh.view.OrderView;

import java.util.List;

public class OrderController {

    private OrderService orderService = new OrderService();

    //private AreaService areaService;

    private BookAreaService bookAreaService = new BookAreaService();

    private OrderAreaService orderAreaService = new OrderAreaService();


    public OrderDto findOrderByOrderId(int orderId) {
        return orderService.findOrderByOrderId(orderId);
    }

    public List<OrderDto> findOrderByInWarehousingId(int inWarehousingId) {
        List<OrderDto> orderDtoList = orderService.findOrderByInWarehousingId(inWarehousingId);
        OrderView.displayOrderDto(orderDtoList);
        return orderDtoList;
    }

    // 출고 내역의 상세 정보 조회
    public List<OrderDto> findOrdersWithExWarehousingId(int exWarehousingId) {
        return orderService.findOrdersByExWarehousingId(exWarehousingId);

    }

    public void reserveOrder(int orderId, String location, String areaName) {

        //Area area = areaService.findByLocationAndAreaName(location, areaName);

        OrderDto order = orderService.findOrderByOrderId(orderId);

        int quantity = order.getQuantity();

        //입고 요청된 수량만큼 업데이트
        //areaService.updateReserved(area.getAreaId(), quantity);

        //int bookAreaId = bookAreaService.reserveBookArea(area.getAreaId(),order.getBookId(), quantity, areaName);
        int bookAreaId = 1;
        orderAreaService.insertOrderArea(orderId, bookAreaId);

    }

    // 입고 내역의 배정된 구역 확인
    // 제목, ISBN, 수량, 창고 위치, 구역 이름
    public OrderAreaDetailDto findOrderAreaDetailByOrderId(int orderId) {
        OrderAreaDetailDto orderAreaDetailDto = orderService.findOrderAreaDetailByOrderId(orderId);
        OrderView.displayOrderAreaDetail(orderAreaDetailDto);
        return orderAreaDetailDto;
    }

    public void completeOrder(int orderId) {

        OrderDto order = orderService.findOrderByOrderId(orderId);
        // Area quantity (reserved -= order.quantity) update
        int quantity = orderService.findOrderByOrderId(orderId).getQuantity();
        //areaService.updateQuantity(orderId, quantity);

        // BookArea quantity (reserved -= order.quantity)update
        int bookId = order.getBookId();
        bookAreaService.updateQuantity(orderId, bookId);

    }
    // 출고 내역의 배정된 구역 확인
    // 제목, ISBN, 수량, 창고 위치, 구역 이름


}
