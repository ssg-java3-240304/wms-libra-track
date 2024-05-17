package com.sh.model.service;

import com.sh.model.entity.Status;

import java.util.Date;
import java.util.HashMap;

public class InWarehousingService {

    private InWarehousingDAO inWarehousingDAO;

    public void insertInWarehousing(HashMap<String, Integer> orders, String publisherName) {

        InWarehousing inWarehousing = new InWarehousing();

        inWarehousing.setDate(new Date());
        inWarehousing.setStatus(Status.PENDING);

        int publisherId = publisherService.findPublisherId(publisherName);
        inWarehousing.setPublisherId(publisherId);

        InWarehousingDAO.inserInWarehousing(inWarehousing);

        int inWarehousingId = inWarehousing.getId();
        // iterate over orders

        for (String ISBN : orders.keySet()) {
            int quantity = orders.get(ISBN);
            // db query to find bookId using ISBN
            int bookId = bookService.findBookIdByPublisherIdAndISBN(publisherId, ISBN);

            Order order = new Order(quantity, bookId, inWarehousingId);

            OrderDAO.inserOrder(order);

        }
    }

    public List<InWarehousing> findInWarehousingByStatus(Status status) {
        return inWarehousingDAO.findInWarehousingByStatus(status);
    }

    public List<Order> findOrderByInWarehousingId(int inWarehousingId) {
        return inWarehousingId.findOrderByInWarehousingId(inWarehousingId);
    }
}