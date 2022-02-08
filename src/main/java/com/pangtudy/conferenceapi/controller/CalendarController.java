package com.pangtudy.conferenceapi.controller;

import com.pangtudy.conferenceapi.core.channel.ScheduleChannel;
import com.pangtudy.conferenceapi.dto.ScheduleDto;
import com.pangtudy.conferenceapi.dto.ScheduleEventDto;
import com.pangtudy.conferenceapi.service.CalendarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/calendar")
@RequiredArgsConstructor
public class CalendarController {
    private final CalendarService calendarService;
    private final ScheduleChannel scheduleChannel;

    @GetMapping("/{year}/schedules")
    public Flux<ScheduleDto> getSchedulesByYear(@PathVariable int year) {
        return calendarService.retrieveSchedules(year);
    }

    @GetMapping("/schedules/{id}")
    public Mono<ScheduleDto> getSchedulesById(@PathVariable long id) {
        return calendarService.findById(id);
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

    @GetMapping(value = "/schedules/sse", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ScheduleEventDto> scheduleSse() {
        return scheduleChannel.asFlux();
    }
}
