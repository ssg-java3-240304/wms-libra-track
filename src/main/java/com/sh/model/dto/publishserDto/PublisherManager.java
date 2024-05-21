package com.sh.model.dto.publishserDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublisherManager {
    private int publisherManagerId;
    private int memberId;
    private int publisherId;
}
