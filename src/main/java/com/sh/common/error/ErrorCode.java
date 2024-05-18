package com.sh.common.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


public enum ErrorCode {
    FAIL_SEARCH_ISBN("해당 ISBN 정보와 일치하지 않는 책이 없습니다. ISBN코드를 다시 확인해주세요.");

    ErrorCode(String msg) {
        this.msg = msg;
    }

    final String msg;
}
