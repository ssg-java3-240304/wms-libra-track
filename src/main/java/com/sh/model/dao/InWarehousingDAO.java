package com.sh.model.dao;

public interface InWarehousingDAO {
    void insertInWarehousing(InWarehousing inWarehousing);

    List<InWarehousing> findInWarehousingByStatus(Status status);
}
