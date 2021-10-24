package com.pangtudy.conferenceapi.service;

import com.pangtudy.conferenceapi.dto.ScheduleDto;
import com.pangtudy.conferenceapi.entity.Schedule;
import com.pangtudy.conferenceapi.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class CalendarService {
    private final ScheduleRepository scheduleRepository;

    public Flux<ScheduleDto> retrieveSchedules(int year) {
        return scheduleRepository.findByYearOrderByStartTime(year)
                .map(ScheduleDto::of);
    }

    @Transactional
    public Mono<ScheduleDto> saveSchedule(ScheduleDto scheduleDto) {
        return scheduleRepository.save(Schedule.of(scheduleDto)).map(ScheduleDto::of);
    }

    @Transactional
    public Mono<ScheduleDto> updateSchedule(long idx, ScheduleDto scheduleDto) {
        return scheduleRepository.findById(idx)
                .map(schedule -> {
                    schedule.setTitle(scheduleDto.getTitle());
                    schedule.setStartTime(scheduleDto.getStartTime());
                    schedule.setEndTime(scheduleDto.getEndTime());
                    schedule.setComment(scheduleDto.getComment());
                    schedule.setAlarm(scheduleDto.getAlarm());
                    return schedule;
                })
                .flatMap(schedule -> scheduleRepository.save(schedule).map(ScheduleDto::of));
    }

    @Transactional
    public Mono<Void> deleteSchedule(long idx) {
        return scheduleRepository.deleteById(idx);
    }
}
