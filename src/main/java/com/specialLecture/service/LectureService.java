package com.specialLecture.service;

import com.specialLecture.dto.UserLectureResponseDto;
import com.specialLecture.entity.UserLecture;
import com.specialLecture.common.handler.LockHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;

@RequiredArgsConstructor
@Service
public class LectureService {
    private final LectureManager lectureManager;
    private final LockHandler lockHandler;

    @Transactional(rollbackFor = Exception.class)
    public UserLectureResponseDto register (Long userId, Long lectureId) {
        String key = userId + ":" + lectureId + ":" + ZonedDateTime.now();
        return lockHandler.executeOnLock(key, () -> {
            // 접수 시간 및 남은 인원수 확인 + 정원 차감
            lectureManager.check(lectureId);
            // 강의 등록
            UserLecture userLecture = lectureManager.register(userId, lectureId);
            return new UserLectureResponseDto(userLecture);
        });
    }
    @Transactional(rollbackFor = Exception.class)
    public Boolean getRegisterStatus (Long userId, Long lectureId) {
        // 해당 수업 접수된건지 조회
        return lectureManager.getUserLecture(userId, lectureId);
    }

}
