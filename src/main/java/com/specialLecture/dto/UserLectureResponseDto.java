package com.specialLecture.dto;

import com.specialLecture.entity.UserLecture;
import lombok.Getter;

@Getter
public class UserLectureResponseDto {
    private Long id;
    private Long userId;
    private Long lectureId;

    public UserLectureResponseDto(UserLecture userLecture){
        this.id = userLecture.getId();
        this.userId = userLecture.getUserId();
        this.lectureId = userLecture.getId();
    }
}
