package com.sh.model.dao;

public interface OrderDAO {

    void insertOrder(Order order);

    Order findOrder();
}
