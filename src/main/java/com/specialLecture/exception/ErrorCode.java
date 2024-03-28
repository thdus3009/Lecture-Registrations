package com.specialLecture.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    ALREADY_REGISTERED_USER(HttpStatus.BAD_REQUEST, "111", "이미 신청완료 되었습니다."),
    NOT_EXISTED_LECTURE(HttpStatus.BAD_REQUEST, "102", "해당 수업이 존재하지 않습니다."),
    NOT_START_TIME(HttpStatus.BAD_REQUEST, "103", "아직 접수가 시작되지 않았습니다."),
    NOT_ENOUGH_CAPACITY(HttpStatus.BAD_REQUEST, "103", "수강 인원 자리가 남아있지 않습니다.");
    private final HttpStatus status;
    private final String code;
    private final String message;

    ErrorCode(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
