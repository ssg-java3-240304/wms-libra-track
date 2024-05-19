package com.sh.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
public enum Role {
    INVENTROY("창고관리자"), PUBLISEHR("출판사"), ADMIN("슈퍼관리자");

    @Getter
    final String role;
}
