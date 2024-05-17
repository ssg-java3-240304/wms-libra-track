package com.sh.model.dao;

import com.sh.model.entity.InWarehousing;
import com.sh.model.entity.Status;

import java.util.List;

public interface InWarehousingDao {
    int insertInWarehousing(InWarehousing inWarehousing);

    void insertOrders(InWarehousing inWarehousing);
    List<InWarehousing> findInWarehousingByStatus(Status status);


}
