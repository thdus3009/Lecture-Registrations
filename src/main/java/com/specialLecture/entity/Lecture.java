package com.specialLecture.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    Long id = 0L;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "capacity", nullable = false)
    Long capacity;

    @Column(name = "update_time", nullable = false)
    Long updateTime;

    @OneToOne(mappedBy = "lecture")
    private Lecture lecture;

}
