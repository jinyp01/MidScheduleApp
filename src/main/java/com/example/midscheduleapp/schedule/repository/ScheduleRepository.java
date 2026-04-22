package com.example.midscheduleapp.schedule.repository;

import com.example.midscheduleapp.schedule.Entity.Schedule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    Page<Schedule> findAll(Pageable page);

}
