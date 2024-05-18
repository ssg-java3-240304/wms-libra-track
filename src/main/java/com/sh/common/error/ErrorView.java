package com.sh.common.error;

public class ErrorView {
    public static void displayError(ErrorCode errorCode) {
        System.out.println(errorCode.getMsg());
    }

}
