package com.specialLecture.exception;

import lombok.Getter;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;

@Log4j
@Getter
public class BusinessException extends RuntimeException{
    private HttpStatus status;
    private String code;
    private String message;

    public BusinessException (ErrorCode errorCode){
        this.status = errorCode.getStatus();
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }
}
