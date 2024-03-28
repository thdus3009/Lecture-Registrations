package com.specialLecture.lecture.repository;

import com.specialLecture.entity.UserLecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserLectureJpaRepository extends JpaRepository<UserLecture, Long> {
    public Optional<UserLecture> findByUserIdAndLectureId(Long userId, Long lectureId);
}
