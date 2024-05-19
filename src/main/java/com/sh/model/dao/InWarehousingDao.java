package com.sh.model.dao;

import com.sh.model.entity.InWarehousing;
import com.sh.model.entity.Status;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InWarehousingDao {
    int insertInWarehousing(InWarehousing inWarehousing);

    void insertOrders(InWarehousing inWarehousing);
    List<InWarehousing> findInWarehousingByStatus(Status status);

    void updateInWarehousingStatus(@Param("inWarehousingId")int inWarehousingId,@Param("status") Status status);

    int findPublisherIdByInWarehousingId(int inWarehousingId);

    List<InWarehousing> findInWarehousingByPublisher(int publisherId);

    List<InWarehousing> findInWarehousingByPublisherManagerId(int publisherManagerId);

    List<InWarehousing> findInWarehousingByPublisherManagerIdAndStatus(@Param("publisherManagerId") int publisherManagerId
            ,@Param("status") Status status);

    List<InWarehousing> findInWarehousingByPublisherIdAndStatus(@Param("publisherId") int publisherId
            ,@Param("status") Status status);
}
