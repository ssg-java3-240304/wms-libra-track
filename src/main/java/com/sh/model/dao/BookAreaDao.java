package com.sh.model.dao;

import com.sh.model.entity.BookArea;

public interface BookAreaDao {

    BookArea findBookAreaByAreaIdAndBookId(int areaId, int bookId);

    int insertBookArea(BookArea bookArea);

    void updateBookArea(BookArea bookArea);
}
