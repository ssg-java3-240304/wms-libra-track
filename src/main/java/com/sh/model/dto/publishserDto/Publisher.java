package com.sh.model.dto.publishserDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Publisher {

    private int publisherId;
    private String name;
    private String email;
    private String phoneNumber;
    private String businessNumber;
}
