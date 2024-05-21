package com.sh.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
public enum Role {
    INVENTROY("INVENTORY"), PUBLISHER("PUBLISHER"), ADMIN("SUPERADMIN");

    @Getter
    final String role;
}
