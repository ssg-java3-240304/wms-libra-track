package com.sh.controller;

import com.sh.model.service.OrderService;

public class OrderController {

    private OrderService orderService;
    public Order findOrderByOrderId(int orderId) {
        return orderService.findOrderByOrderId(orderId);
    }
}
