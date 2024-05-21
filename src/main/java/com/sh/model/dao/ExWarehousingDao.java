package com.sh.model.dao;

import com.sh.model.entity.ExWarehousing;
import com.sh.model.entity.Status;

import java.util.List;

public interface ExWarehousingDao {
    int save(ExWarehousing exWarehousing);
    List<ExWarehousing> findExWarehousingByStatus(Status status);

    void updateExWarehousingStatus(int exWarehousingId, int inventoryManagerId, Status status);

    List<ExWarehousing> findExWarehousingByPublisher(int publisherId);

    int insertExWarehousing(ExWarehousing exWarehousing);

    void insertOrders(ExWarehousing exWarehousing);
}
