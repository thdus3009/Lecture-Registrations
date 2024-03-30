package com.specialLecture.repository;

import com.specialLecture.entity.UserLecture;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserLectureRepository {
    Optional<UserLecture> findByUserIdAndLectureId(Long userId, Long LectureId);
    UserLecture save(UserLecture userLecture);
}
