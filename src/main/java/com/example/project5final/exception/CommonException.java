package com.example.project5final.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.http.HttpStatus;
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonException extends RuntimeException {
    private String message;
    private HttpStatus httpStatus;
    private Throwable throwable;

    public CommonException(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public CommonException(String message, Throwable throwable) {
        this.message = message;
        this.throwable = throwable;
    }

    public CommonException(String message) {
        super(message);
        this.message = message;
    }
}
