package com.pangtudy.conferenceapi.service;

import com.pangtudy.conferenceapi.dto.ScheduleDto;
import com.pangtudy.conferenceapi.entity.Schedule;
import com.pangtudy.conferenceapi.repository.ScheduleRepository;
import io.r2dbc.spi.ConnectionFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;

@Slf4j
@Service
@RequiredArgsConstructor
public class CalendarService {
    private final ScheduleRepository scheduleRepository;
    private final ConnectionFactory connectionFactory;
    private R2dbcEntityTemplate template;
    private static long pk = 4;

    @PostConstruct
    public void initialize() {
        template = new R2dbcEntityTemplate(connectionFactory);
    }

    public Flux<ScheduleDto> retrieveSchedules(int year) {
        return scheduleRepository.findByYear(year)
                .map(schedule -> ScheduleDto.builder()
                            .year(schedule.getYear())
                            .month(schedule.getMonth())
                            .day(schedule.getDay())
                            .build());
//        return template.select(query(where("year").is(year)), Schedule.class)
//                .map(schedule -> ScheduleDto.builder()
//                            .year(schedule.getYear())
//                            .month(schedule.getMonth())
//                            .day(schedule.getDay())
//                            .build());
    }

    @Transactional
    public Mono<ScheduleDto> saveSchedule(int year, int month, int body) {
//        return scheduleRepository.save(new Schedule(pk++, year, month, body))
//                .map(schedule -> ScheduleDto.builder()
//                        .year(schedule.getYear())
//                        .month(schedule.getMonth())
//                        .day(schedule.getDay())
//                        .build());
        return template.insert(new Schedule(pk++, year, month, body))
                .map(schedule -> ScheduleDto.builder()
                        .year(schedule.getYear())
                        .month(schedule.getMonth())
                        .day(schedule.getDay())
                        .build());
    }
}
