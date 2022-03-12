package com.pangtudy.conferenceapi.repository;

import com.pangtudy.conferenceapi.entity.Participant;
import com.pangtudy.conferenceapi.entity.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

import static org.springframework.data.relational.core.query.Criteria.where;
import static org.springframework.data.relational.core.query.Query.query;

@Repository
@RequiredArgsConstructor
public class CustomScheduleRepositoryImpl implements CustomScheduleRepository {
    private final R2dbcEntityTemplate r2dbcEntityTemplate;

    @Override
    public Mono<Schedule> findWithParticipantsById(Long id) {
        return r2dbcEntityTemplate.selectOne(query(where("id").is(id)), Schedule.class)
                .flatMap(schedule -> r2dbcEntityTemplate.select(query(where("schedule_id").is(id)), Participant.class)
                            .collectList()
                            .map(participants -> {
                                schedule.setParticipants(participants);
                                return schedule;
                            })
                );
    }

    @Override
    public Flux<Schedule> findWithParticipantsByYearOrderByStartTime(int year) {
        // TODO : N + 1 문제 해결하기
        return r2dbcEntityTemplate.select(query(where("year").is(year)), Schedule.class)
                .flatMap(schedule -> r2dbcEntityTemplate.select(query(where("schedule_id").is(schedule.getId())), Participant.class)
                        .collectList()
                        .map(participants -> {
                            schedule.setParticipants(participants);
                            return schedule;
                        })
                );
    }

    @Override
    public Mono<Schedule> saveWithParticipant(Schedule schedule) {
        if (schedule.getId() == null || schedule.getId() == 0) {
            return this.insertWithParticipant(schedule);
        }
        else {
            return this.updateWithParticipant(schedule);
        }
    }

    // insert into schedule values (:year, :month, :day, :title, :startTime, :endTime, :writer, :alarm, :comment);
    // insert into participant_info values (:schedule_id, :user_email, :user_name);
    // insert into participant_info values (:schedule_id, :user_email, :user_name);
    // insert into participant_info values (:schedule_id, :user_email, :user_name);
    private Mono<Schedule> insertWithParticipant(Schedule schedule) {
        return r2dbcEntityTemplate.insert(schedule)
                .flatMap(s ->
                    Flux.concat(schedule.getParticipants().stream()
                            .map(participant -> r2dbcEntityTemplate.insert(Participant.of(schedule.getId(), participant.getUserEmail(), participant.getUserName())))
                            .collect(Collectors.toList()))
                            .collectList()
                            .map(participants -> {
                                s.setParticipants(participants);
                                return s;
                            })
                );
    }

    private Mono<Schedule> updateWithParticipant(Schedule schedule) {
        return Mono.empty();
    }
}
