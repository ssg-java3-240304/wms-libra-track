package com.sh.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

//홍지민 작업 시작
public class PublisherManagerDto {
    private int publisherManagerId;
    private int memberId;
    private int publisherId;

    public PublisherManagerDto(int memberId, int publisherId) {
        this.memberId = memberId;
        this.publisherId = publisherId;
    }
}
//홍지민 작업 끝