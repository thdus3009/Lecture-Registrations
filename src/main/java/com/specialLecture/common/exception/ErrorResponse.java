package com.specialLecture.common.exception;

public record ErrorResponse(
        String code,
        String message
) {
}
