package com.sh.common.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ErrorCode {
    FAIL_SEARCH_ISBN("해당 ISBN 정보와 일치하지 않는 책이 없습니다. ISBN코드를 다시 확인해주세요."),

    SAME_ISBN("해당 ISBN 정보와 일치하는 책이 이미 존재합니다."),

    DUPLICATE_PUBLISHER_INFORMATION("해당 출판사의 정보는 이미 등록되어있는 정보입니다. 입력을 다시 확인해주세요") ;

    @Getter
    final String msg;
}
