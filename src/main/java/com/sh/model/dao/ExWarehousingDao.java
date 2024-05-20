package com.sh.model.dao;

import com.sh.model.entity.ExWarehousing;
import com.sh.model.entity.Status;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExWarehousingDao {
    int save(ExWarehousing exWarehousing);
    List<ExWarehousing> findExWarehousingByStatus(Status status);


    void updateExWarehousingStatus(@Param("exWarehousingId") int exWarehousingId, @Param("inventoryManagerId") int inventoryManagerId, @Param("status") Status status);

    List<ExWarehousing> findExWarehousingByPublisher(int publisherId);

    List<ExWarehousing> findExWarehousingByPublisherManager(int publisherManagerId);

    List<ExWarehousing> findExWarehousingByPublisherIdAndStatus(@Param("publisherId") int publisherId, @Param("status") Status status);

    List<ExWarehousing> findExWarehousingByPublisherManagerIdAndStatus(@Param("publisherManagerId") int publisherManagerId, @Param("status") Status status);
}
