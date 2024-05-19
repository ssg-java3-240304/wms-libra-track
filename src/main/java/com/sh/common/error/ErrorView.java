package com.sh.common.error;

import lombok.Getter;

public class ErrorView {
    public static void displayError(ErrorCode errorCode) {
        System.out.println(errorCode.getMsg());
    }



}
