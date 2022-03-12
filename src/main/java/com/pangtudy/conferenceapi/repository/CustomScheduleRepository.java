package com.pangtudy.conferenceapi.repository;

import com.pangtudy.conferenceapi.entity.Schedule;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface CustomScheduleRepository {
    Mono<Schedule> findWithParticipantsById(Long id);
    Flux<Schedule> findWithParticipantsByYearOrderByStartTime(int year);
    Mono<Schedule> saveWithParticipant(Schedule schedule);
    Mono<Void> deleteWithParticipantById(long id);
}
