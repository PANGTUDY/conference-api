package com.pangtudy.conferenceapi.repository;

import com.pangtudy.conferenceapi.entity.Schedule;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface CustomScheduleRepository {
    Mono<Schedule> findWithParticipantsById(Long id);
}
