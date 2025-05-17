package sopt.web1.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import sopt.web1.common.code.ErrorCode;
import sopt.web1.common.code.SuccessCode;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ResponseDto<T>(
        int code,
        T data,
        String message
) {
    public static <T> ResponseDto<T> success(SuccessCode code, final T data) {
        return new ResponseDto<>(code.getCode(), data, null);
    }

    public static <T> ResponseDto<T> fail(ErrorCode code) {
        return new ResponseDto<>(code.getCode(), null, code.getMessage());
    }

    public static <T> ResponseDto<T> fail(int code, final T data) {
        return new ResponseDto<>(code, data, null);
    }
}
