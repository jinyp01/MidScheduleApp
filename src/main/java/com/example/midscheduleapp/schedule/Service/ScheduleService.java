package com.example.midscheduleapp.schedule.Service;

import com.example.midscheduleapp.schedule.Dto.CreateScheduleResponse;
import com.example.midscheduleapp.schedule.Dto.CreateSchesuleRequest;
import com.example.midscheduleapp.schedule.Entity.Schedule;
import com.example.midscheduleapp.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

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
}
