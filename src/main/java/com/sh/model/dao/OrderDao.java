package com.sh.model.dao;

import com.sh.model.dto.OrderDto;
import com.sh.model.entity.Order;

import java.util.List;

public interface OrderDao {

    void insertOrder(Order order);

    List<OrderDto> findOrderByInWarehousingId(int inWarehousingId);

    OrderDto findOrderByOrderId(int orderId);
}
