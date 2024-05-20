package com.sh.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderAreaDetailDto {
    private String title;
    private String ISBN;
    private int quantity;
    private String location;
    private String areaName;
}
