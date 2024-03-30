package com.specialLecture.service;

import com.specialLecture.entity.Lecture;
import com.specialLecture.entity.UserLecture;
import com.specialLecture.common.exception.BusinessException;
import com.specialLecture.common.exception.ErrorCode;
import com.specialLecture.repository.LectureRepository;
import com.specialLecture.repository.UserLectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Component
class UserLectureReader{
    private final UserLectureRepository userLectureRepository;

    public Optional<UserLecture> read(Long userId, Long lectureId){
        return userLectureRepository.findByUserIdAndLectureId(userId, lectureId);
    }
}
@RequiredArgsConstructor
@Component
class UserLectureWriter{
    private final UserLectureRepository userLectureRepository;

    public UserLecture save(UserLecture userLecture){
        return userLectureRepository.save(userLecture);
    }
}
@RequiredArgsConstructor
@Component
class LectureReader{
    private final LectureRepository lectureRepository;

    @Cacheable(value = "lecture", key = "#lectureId")
    public Optional<Lecture> read(Long lectureId){
        return lectureRepository.findById(lectureId);
    }
}
@RequiredArgsConstructor
@Component
class LectureWriter{
    private final LectureRepository lectureRepository;

    public Lecture save(Lecture lecture){
        return lectureRepository.save(lecture);
    }
}

@RequiredArgsConstructor
@Component
public class LectureManager{
    private final UserLectureReader userLectureReader;
    private final UserLectureWriter userLectureWriter;
    private final LectureReader lectureReader;
    private final LectureWriter lectureWriter;

    public void check(Long lectureId){
        // 해당 강의가 있는지 확인
        Optional<Lecture> lecture = lectureReader.read(lectureId);
        if(lecture.isEmpty()) throw new BusinessException(ErrorCode.NOT_EXISTED_LECTURE);

        // 현재 시간과 접수 시작 시간을 확인
        ZonedDateTime startTime = lecture.get().getOpenTime();
        ZonedDateTime nowTime = ZonedDateTime.now();
        if(startTime.isAfter(nowTime)) throw new BusinessException(ErrorCode.NOT_START_TIME);

        // 자리가 남아 있는지 확인
        if(lecture.get().getRemainCapacity()==0) throw new BusinessException(ErrorCode.NOT_ENOUGH_CAPACITY);

        // 강의 정원 수 차감
        lecture.get().decreaseCapacity();
        lectureWriter.save(lecture.get());
    }

    public UserLecture register(Long userId, Long lectureId){
        Optional<UserLecture> userLecture = userLectureReader.read(userId, lectureId);
        // 등록 유무 체크
        if(!userLecture.isEmpty()) throw new BusinessException(ErrorCode.ALREADY_REGISTERED_USER);

        // UserLecture 등록
        UserLecture newUserLecture = new UserLecture(userId, lectureId);
        return userLectureWriter.save(newUserLecture);
    }

    public Boolean getUserLecture(Long userId, Long lectureId){
        Optional<UserLecture> userLecture = userLectureReader.read(userId, lectureId);
        if(userLecture.isEmpty()) return false;
        else return true;
    }

}
