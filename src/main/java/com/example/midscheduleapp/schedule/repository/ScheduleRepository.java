package com.example.midscheduleapp.schedule.repository;

import com.example.midscheduleapp.schedule.Entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
