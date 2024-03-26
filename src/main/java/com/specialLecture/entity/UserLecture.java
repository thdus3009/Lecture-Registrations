package com.specialLecture.entity;

import jakarta.persistence.*;

@Entity
public class UserLecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    Long id = 0L;

    @OneToOne
    @JoinColumn(name = "lecture_id")
    Lecture lecture;

    @Column(name = "user_id", nullable = false)
    Long userId;

    @Column(name = "update_time", nullable = false)
    Long updateTime;
}
