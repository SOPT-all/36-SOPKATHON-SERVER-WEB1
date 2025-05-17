package sopt.web1.common.code;

import org.springframework.http.HttpStatus;

public interface ApiCode {
    HttpStatus getHttpStatus();
    int getCode();
    String getMessage();
}
