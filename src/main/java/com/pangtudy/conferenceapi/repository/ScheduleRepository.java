package com.pangtudy.conferenceapi.repository;

import com.pangtudy.conferenceapi.entity.Schedule;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface ScheduleRepository extends ReactiveCrudRepository<Schedule, Long>, CustomScheduleRepository {
    Flux<Schedule> findByYearOrderByStartTime(int year);

}
