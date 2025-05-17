package sopt.web1.exception;

import sopt.web1.common.code.ErrorCode;

public class NotFoundException extends RuntimeException {
    private final ErrorCode errorCode;

    public NotFoundException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}