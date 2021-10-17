package com.pangtudy.conferenceapi.repository;

import com.pangtudy.conferenceapi.entity.Schedule;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;

public interface ScheduleRepository extends ReactiveCrudRepository<Schedule, Long> {
    Flux<Schedule> findByStartTimeBetween(LocalDateTime startTime, LocalDateTime startTime2);
}
