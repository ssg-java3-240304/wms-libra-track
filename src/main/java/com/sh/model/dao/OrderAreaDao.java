package com.sh.model.dao;

import com.sh.model.entity.OrderArea;

public interface OrderAreaDao {
    void insertOrderArea(OrderArea orderArea);

    OrderArea findOrderAreaByOrderId(int orderId);
}
