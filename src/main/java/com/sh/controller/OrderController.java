package com.sh.controller;

import com.sh.area.model.dto.AreaDto;
import com.sh.area.model.service.AreaService;
import com.sh.model.dto.OrderAreaDetailDto;
import com.sh.model.dto.OrderDto;
import com.sh.model.entity.BookArea;
import com.sh.model.service.BookAreaService;
import com.sh.model.service.OrderAreaService;
import com.sh.model.service.OrderService;
import com.sh.view.OrderView;

import java.awt.geom.Area;
import java.util.List;

public class OrderController {

    private OrderService orderService = new OrderService();

    private AreaService areaService = new AreaService();

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

    public void reserveOrder(int orderId, String location, String areaName, boolean inWarehousing) {

        AreaDto area = areaService.findByLocationAndAreaName(location, areaName);

        OrderDto order = orderService.findOrderByOrderId(orderId);

        int quantity = order.getQuantity();

        if(!inWarehousing) {
            quantity *= -1;
        }

        //입/출고 요청된 수량만큼 업데이트

        area.setReserved(area.getReserved() + quantity);

        areaService.updateArea(area);

        int bookAreaId = bookAreaService.reserveBookArea(area.getAreaId(),order.getBookId(), quantity, areaName);

        //int bookAreaId = 1;
        orderAreaService.insertOrderArea(orderId, bookAreaId);

    }

    // 입고 내역의 배정된 구역 확인
    // 제목, ISBN, 수량, 창고 위치, 구역 이름
    public OrderAreaDetailDto findOrderAreaDetailByOrderId(int orderId) {
        OrderAreaDetailDto orderAreaDetailDto = orderService.findOrderAreaDetailByOrderId(orderId);
        OrderView.displayOrderAreaDetail(orderAreaDetailDto);
        return orderAreaDetailDto;
    }

    public void completeOrder(int orderId, boolean inWarehousing) {

        OrderDto order = orderService.findOrderByOrderId(orderId);
        // Area quantity (reserved -= order.quantity) update

        int quantity = orderService.findOrderByOrderId(orderId).getQuantity();

        if(!inWarehousing) {
            quantity *= -1;
        }

        AreaDto area = bookAreaService.findAreaByOrderId(orderId);

        area.setReserved(area.getReserved() + quantity);
        area.setQuantity(area.getQuantity() - quantity);

        areaService.updateArea(area);

        // BookArea quantity (reserved -=  order.quantity)update
        int bookId = order.getBookId();
        bookAreaService.updateQuantity(area.getAreaId(), bookId, quantity);

    }

}
