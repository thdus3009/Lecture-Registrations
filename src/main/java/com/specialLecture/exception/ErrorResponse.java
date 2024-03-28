package com.specialLecture.exception;

public record ErrorResponse(
        String code,
        String message
) {
}
