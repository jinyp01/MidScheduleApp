package com.example.midscheduleapp.schedule.Entity;


import com.example.midscheduleapp.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "schedules")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Schedule extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleId;
    private Long userId;
    @Column(length = 50, nullable = false)
    private String title;
    private String content;

    public Schedule(Long userId, String title, String content) {
        this.userId = userId;
        this.title = title;
        this.content = content;
    }

    public void updateSchedule(String title, String content){
        this.title = title;
        this.content = content;
    }
}
