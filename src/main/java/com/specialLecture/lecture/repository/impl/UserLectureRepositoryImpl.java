package com.specialLecture.lecture.repository.impl;

import com.specialLecture.entity.UserLecture;
import com.specialLecture.lecture.repository.UserLectureJpaRepository;
import com.specialLecture.lecture.repository.UserLectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class UserLectureRepositoryImpl implements UserLectureRepository {
    private final UserLectureJpaRepository userLectureJpaRepository;
    @Override
    public Optional<UserLecture> findByUserIdAndLectureId(Long userId, Long lectureId) {
        return userLectureJpaRepository.findByUserIdAndLectureId(userId, lectureId);
    }

    @Override
    public UserLecture save(UserLecture userLecture) {
        return userLectureJpaRepository.save(userLecture);
    }
}
