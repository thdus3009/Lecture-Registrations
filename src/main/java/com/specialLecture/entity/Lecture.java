package com.specialLecture.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.ZonedDateTime;

@Getter
@Entity
@Table(schema = "lecture_enrollment", name = "lecture")
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    Long id = 0L;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "capacity", nullable = false)
    Long capacity;

    @Column(name = "open_time", nullable = false)
    ZonedDateTime openTime;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, insertable = true, updatable = false)
    ZonedDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = true, insertable = true, updatable = true)
    ZonedDateTime updatedAt = null;

    // capacity 수정
    public void decreaseCapacity(){
        this.capacity = this.capacity-1;
    }

}
