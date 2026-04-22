package com.example.midscheduleapp.schedule.Controller;

import com.example.midscheduleapp.schedule.Dto.*;
import com.example.midscheduleapp.schedule.Entity.Schedule;
import com.example.midscheduleapp.schedule.Service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    // 일정 생성
    @PostMapping("/users/{userId}/schedules")
    ResponseEntity<CreateScheduleResponse> createSchedule(
            @Validated
            @PathVariable Long userId,
            @RequestBody CreateSchesuleRequest request) {
        CreateScheduleResponse result = scheduleService.save(userId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    // 일정 전체 조회
    @GetMapping("/users/{userId}/schedules")
    ResponseEntity<List<GetScheduleResponse>> getSchedules(
            @PathVariable Long userId
    ){
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.getAll(userId));
    }

    // (페이징) 일정 전체 조회
    @GetMapping("/schedules/page")
    ResponseEntity<PageScheduleResponse<GetScheduleResponse>> getPageSchedules(
            @RequestParam(defaultValue = "0")int page,
            @RequestParam(defaultValue = "10")int size
    ){
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.getPageAll(page, size));
    }

    // 일정 단건 조회
    @GetMapping("/users/{userId}/schedules/{scheduleId}")
    ResponseEntity<GetScheduleResponse> getSchedule(
            @PathVariable Long scheduleId) {
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.getOne(scheduleId));
    }

    // 일정 업데이트
    @PutMapping("/users/{userId}/schedules/{scheduleId}")
    ResponseEntity<UpdateScheduleResponse> updateSchedule(
            @Validated
            @PathVariable Long scheduleId,
            @RequestBody UpdateScheduleRequest request
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.update(scheduleId, request));
    }

    // 일정 삭제
    @DeleteMapping("/users/{userId}/schedules/{scheduleId}")
    ResponseEntity<Void>deleteSchedule(
            @PathVariable Long scheduleId) {
        scheduleService.delete(scheduleId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }



}
