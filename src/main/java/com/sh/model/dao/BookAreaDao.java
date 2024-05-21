package com.sh.model.dao;

import com.sh.model.dto.AreaDto;
import com.sh.model.entity.BookArea;
import org.apache.ibatis.annotations.Param;

public interface BookAreaDao {

    BookArea findBookAreaByAreaIdAndBookId(@Param("areaId") int areaId, @Param("bookId") int bookId);

    int insertBookArea(BookArea bookArea);

    void updateBookArea(BookArea bookArea);

    AreaDto findAreaByOrderId(int orderId);
}
