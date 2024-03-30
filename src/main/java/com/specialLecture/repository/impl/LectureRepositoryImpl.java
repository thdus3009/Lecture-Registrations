package com.specialLecture.repository.impl;

import com.specialLecture.entity.Lecture;
import com.specialLecture.repository.LectureJpaRepository;
import com.specialLecture.repository.LectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class LectureRepositoryImpl implements LectureRepository {
    private final LectureJpaRepository lectureJpaRepository;
    @Override
    public Optional<Lecture> findById(Long lectureId) {
        return lectureJpaRepository.findById(lectureId);
    }

    @Override
    public Lecture save(Lecture lecture) {
        return lectureJpaRepository.save(lecture);
    }

}
