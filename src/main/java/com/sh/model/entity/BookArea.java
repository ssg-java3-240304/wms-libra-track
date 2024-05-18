package com.sh.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookArea {
    private int bookAreaId;
    private int areaId;
    private int bookId;
    private int quantity;
    private int reserved;
}
