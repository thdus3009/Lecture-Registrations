package com.specialLecture.repository;

import com.specialLecture.entity.Lecture;

import java.util.Optional;

public interface LectureRepository {
    // 단위 테스트를 위해 & 내가 제어할 수 없는 부분에 대해서는 추상화를 두어야한다.
    Optional<Lecture> findById(Long lectureId);
    Lecture save(Lecture lecture);
}
