package sopt.web1.exception;

import lombok.RequiredArgsConstructor;
import sopt.web1.common.code.ErrorCode;

@RequiredArgsConstructor
public class NotFoundCategoryException extends RuntimeException{
    private final ErrorCode errorCode;
}
