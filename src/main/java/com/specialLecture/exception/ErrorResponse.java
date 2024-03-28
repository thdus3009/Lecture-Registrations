package com.specialLecture.exception;

import org.springframework.http.HttpStatus;

public record ErrorResponse (
        HttpStatus status,
        String code,
        String message
){
}
