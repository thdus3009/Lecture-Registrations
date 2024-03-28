package com.specialLecture.exception;

import org.springframework.stereotype.Component;

@Component
public class ErrorCode {
    public static final String ALREADY_REGISTERED_USER = "이미 신청완료 되었습니다.";
    public static final String NOT_EXISTED_LECTURE = "해당 수업이 존재하지 않습니다.";
    public static final String NOT_START_TIME = "아직 접수가 시작되지 않았습니다.";
    public static final String NOT_ENOUGH_CAPACITY = "아직 접수가 시작되지 않았습니다.";

}
