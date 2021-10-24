package com.pangtudy.conferenceapi.controller;

import com.pangtudy.conferenceapi.dto.ScheduleDto;
import com.pangtudy.conferenceapi.service.CalendarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/calendar")
@RequiredArgsConstructor
public class CalendarController {
    private final CalendarService calendarService;

    @GetMapping("/{year}/schedules")
    public Flux<ScheduleDto> getSchedulesByYear(@PathVariable int year) {
        return calendarService.retrieveSchedules(year);
    }

    @PostMapping("/schedule")
    public Mono<ScheduleDto> setSchedule(
            @RequestBody ScheduleDto scheduleDto
    ) {
        return calendarService.saveSchedule(scheduleDto);
    }

    @PutMapping("/schedules/{idx}")
    public Mono<ScheduleDto> updateSchedule(
            @PathVariable long idx,
            @RequestBody ScheduleDto scheduleDto
    ) {
        return calendarService.updateSchedule(idx, scheduleDto);
    }

    @DeleteMapping("/schedules/{idx}")
    public Mono<Void> deleteSchedule(
            @PathVariable long idx
    ) {
        return calendarService.deleteSchedule(idx);
    }
}
