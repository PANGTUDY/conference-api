package com.pangtudy.conferenceapi.service;

import com.pangtudy.conferenceapi.core.channel.ScheduleChannel;
import com.pangtudy.conferenceapi.dto.ScheduleDto;
import com.pangtudy.conferenceapi.dto.ScheduleEventDto;
import com.pangtudy.conferenceapi.mock.CalendarMock;
import com.pangtudy.conferenceapi.repository.ScheduleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.time.LocalTime;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CalendarServiceTest {
    @Mock
    private ScheduleRepository scheduleRepository;

    private ScheduleChannel scheduleChannel;

    private CalendarService calendarService;

    @BeforeEach
    public void setUp() {
        scheduleChannel = new ScheduleChannel();
        calendarService = new CalendarService(scheduleRepository, scheduleChannel);
    }

    @Test
    public void 연도별_스케줄_조회_검증() {
        // given
        when(scheduleRepository.findByYearOrderByStartTime(2020)).thenReturn(CalendarMock.findSchedulesByYear(2020));
        when(scheduleRepository.findByYearOrderByStartTime(2021)).thenReturn(CalendarMock.findSchedulesByYear(2021));
        when(scheduleRepository.findByYearOrderByStartTime(2022)).thenReturn(CalendarMock.findSchedulesByYear(2022));

        // when
        Flux<ScheduleDto> schedules_2020 = calendarService.retrieveSchedules(2020);
        Flux<ScheduleDto> schedules_2021 = calendarService.retrieveSchedules(2021);
        Flux<ScheduleDto> schedules_2022 = calendarService.retrieveSchedules(2022);

        // then
        StepVerifier.create(schedules_2020)
                .expectNextCount(4)
                .verifyComplete();

        StepVerifier.create(schedules_2021)
                .expectNextCount(10)
                .verifyComplete();

        StepVerifier.create(schedules_2022)
                .expectNextCount(6)
                .verifyComplete();
    }
}