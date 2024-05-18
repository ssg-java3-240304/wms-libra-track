package com.sh.controller;

import com.sh.model.dto.OrderDto;
import com.sh.model.service.BookAreaService;
import com.sh.model.service.OrderAreaService;
import com.sh.model.service.OrderService;

import java.util.List;

public class OrderController {

    private OrderService orderService;

    //private AreaService areaService;

    private BookAreaService bookAreaService;

    private OrderAreaService orderAreaService;

    public OrderDto findOrderByOrderId(int orderId) {
        return orderService.findOrderByOrderId(orderId);
    }

    public List<OrderDto> findOrderByInWarehousingId(int inWarehousingId) {
        return orderService.findOrderByInWarehousingId(inWarehousingId);
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

    public void completeOrder(int orderId) {

        OrderDto order = orderService.findOrderByOrderId(orderId);
        // Area quantity (reserved -= order.quantity) update
        int quantity = orderService.findOrderByOrderId(orderId).getQuantity();
        //areaService.updateQuantity(orderId, quantity);

        // BookArea quantity (reserved -= order.quantity)update
        int bookId = order.getBookId();
        bookAreaService.updateQuantity(orderId, bookId);

    }

}
