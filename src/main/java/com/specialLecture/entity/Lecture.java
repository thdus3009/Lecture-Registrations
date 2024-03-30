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

    @Column(name = "total_capacity", nullable = false)
    Long totalCapacity;

    @Column(name = "remain_capacity", nullable = false)
    Long remainCapacity;

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
        this.remainCapacity = this.remainCapacity-1;
    }
    public void increaseCapacity(){
        this.remainCapacity = this.remainCapacity+1;
    }

    public Lecture(){

    }
    public Lecture(String name, Long totalCapacity, Long remainCapacity, ZonedDateTime openTime){
        this.name = name;
        this.totalCapacity = totalCapacity;
        this.remainCapacity = remainCapacity;
        this.openTime = openTime;
    }
}
