package com.specialLecture.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.ZonedDateTime;

@Getter
@Entity
@Table(name = "Lecture")
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
    public void increaseCapacity(){
        this.capacity = this.capacity+1;
    }
}
