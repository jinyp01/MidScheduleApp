package com.example.midscheduleapp.schedule.Service;

import com.example.midscheduleapp.schedule.Dto.*;
import com.example.midscheduleapp.schedule.Entity.Schedule;
import com.example.midscheduleapp.schedule.repository.ScheduleRepository;
import com.example.midscheduleapp.user.Entity.User;
import com.example.midscheduleapp.user.Repository.UserRepository;
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
    private final UserRepository userRepository;


    // 스케쥴 추가
    @Transactional
    public CreateScheduleResponse save(Long userId, CreateSchesuleRequest request){
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalStateException("해당 유저가 없습니다.")
        );
        Schedule schedule = new Schedule(
                user,
                request.getTitle(),
                request.getContent()
        );
        Schedule saveSchedule = scheduleRepository.save(schedule);

        return  new CreateScheduleResponse(
                saveSchedule.getScheduleId(),
                saveSchedule.getTitle(),
                saveSchedule.getContent()
        );
    }


    // 일정 전체 조회 추가
    @Transactional(readOnly = true)
    public List<GetScheduleResponse> getAll(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalStateException("해당 유저가 없습니다.")
        );

        List<Schedule> schedules = scheduleRepository.findAll();
        List<GetScheduleResponse> dtos = new ArrayList<>();
        for(Schedule schedule : schedules) {
            GetScheduleResponse dto = new GetScheduleResponse(
                    schedule.getScheduleId(),
                    schedule.getTitle(),
                    schedule.getContent()
            );
            dtos.add(dto);
        }
        return dtos;
    }


    // 스케쥴 단건 조회 기능 추가
    @Transactional(readOnly = true)
    public GetScheduleResponse getOne(Long scheduleId) {

        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                ()-> new IllegalStateException("검색된 스케쥴이 없습니다."));
        return new GetScheduleResponse(
                schedule.getScheduleId(),
                schedule.getTitle(),
                schedule.getContent()
        );
    }


    // 스케쥴 수정 기능 추가
    @Transactional(readOnly = true)
    public UpdateScheduleResponse update(Long scheduleId, UpdateScheduleRequest request) {

        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalStateException("검색된 스케쥴이 없습니다.")
        );
        schedule.updateSchedule(request.getTitle(), request.getContent());
        return new UpdateScheduleResponse(
                schedule.getScheduleId(),
                schedule.getTitle(),
                schedule.getContent()
        );
    }


    // 스케쥴 삭제 기능 추가
    @Transactional
    public void delete(Long scheduleId) {
        boolean existence = scheduleRepository.existsById(scheduleId);
        if(!existence) {
            throw new IllegalStateException("검색된 스케쥴이 없습니다.");
        }
        scheduleRepository.deleteById(scheduleId);

    }
}
