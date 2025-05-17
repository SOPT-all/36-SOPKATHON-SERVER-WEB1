package sopt.web1.code;

import org.springframework.http.HttpStatus;

public interface ApiCode {
    HttpStatus getHttpStatus();
    int getCode();
    String getMessage();
}
