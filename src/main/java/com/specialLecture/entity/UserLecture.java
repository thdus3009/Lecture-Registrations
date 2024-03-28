package com.specialLecture.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.ZonedDateTime;

@Getter
@Entity
@Table(schema = "lecture_enrollment", name = "user_lecture")
public class UserLecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    Long id = 0L;

    @Column(name = "lecture_id", nullable = false)
    Long lectureId;

    @Column(name = "user_id", nullable = false)
    Long userId;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, insertable = true, updatable = false)
    ZonedDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = true, insertable = true, updatable = true)
    ZonedDateTime updatedAt = null;

    public UserLecture(Long userId, Long lectureId) {
        this.userId = userId;
        this.lectureId = lectureId;
    }

}
