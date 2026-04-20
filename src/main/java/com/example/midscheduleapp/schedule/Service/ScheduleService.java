package com.example.midscheduleapp.schedule.Service;

import com.example.midscheduleapp.schedule.Dto.CreateScheduleResponse;
import com.example.midscheduleapp.schedule.Dto.CreateSchesuleRequest;
import com.example.midscheduleapp.schedule.Dto.GetScheduleResponse;
import com.example.midscheduleapp.schedule.Entity.Schedule;
import com.example.midscheduleapp.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;



    // 스케쥴 추가
    @Transactional
    public CreateScheduleResponse save(CreateSchesuleRequest request){
        Schedule schedule = new Schedule(
                request.getUserId(),
                request.getTitle(),
                request.getContent()
        );
        Schedule saveSchedule = scheduleRepository.save(schedule);

        return  new CreateScheduleResponse(
                saveSchedule.getScheduleId(),
                saveSchedule.getUserId(),
                saveSchedule.getTitle(),
                saveSchedule.getContent()
        );
    }


    // 일정 전체 조회 추가
    public List<GetScheduleResponse> getAll() {
        List<Schedule> schedules = scheduleRepository.findAll();
        List<GetScheduleResponse> dtos = new ArrayList<>();
        for(Schedule schedule : schedules) {
            GetScheduleResponse dto = new GetScheduleResponse(
                    schedule.getScheduleId(),
                    schedule.getUserId(),
                    schedule.getTitle(),
                    schedule.getContent()
            );
            dtos.add(dto);
        }
        return dtos;
    }


    // 스케쥴 단건 조회 기능 추가
    public GetScheduleResponse getOne(Long scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                ()-> new IllegalStateException("검색된 스케쥴이 없습니다."));
        return new GetScheduleResponse(
                schedule.getScheduleId(),
                schedule.getUserId(),
                schedule.getTitle(),
                schedule.getContent()
        );
    }






}
