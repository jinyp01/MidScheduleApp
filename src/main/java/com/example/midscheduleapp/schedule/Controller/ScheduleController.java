package com.example.midscheduleapp.schedule.Controller;

import com.example.midscheduleapp.schedule.Dto.CreateScheduleResponse;
import com.example.midscheduleapp.schedule.Dto.CreateSchesuleRequest;
import com.example.midscheduleapp.schedule.Dto.GetScheduleResponse;
import com.example.midscheduleapp.schedule.Entity.Schedule;
import com.example.midscheduleapp.schedule.Service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/schedules")
    ResponseEntity<CreateScheduleResponse> createSchedule(CreateSchesuleRequest request) {
        CreateScheduleResponse result = scheduleService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("schedules")
    ResponseEntity<List<GetScheduleResponse>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(scheduleService.getAll());
    }


}
