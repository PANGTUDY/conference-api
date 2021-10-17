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

    @PostMapping("/{year}/{month}/{day}/schedule")
    public Mono<ScheduleDto> setSchedule(
            @PathVariable int year,
            @PathVariable int month,
            @PathVariable int day
    ) {
        return calendarService.saveSchedule(year, month, day);
    }
}
