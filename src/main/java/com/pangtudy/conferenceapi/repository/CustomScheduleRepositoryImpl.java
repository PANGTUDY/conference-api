package com.pangtudy.conferenceapi.repository;

import com.pangtudy.conferenceapi.entity.Participant;
import com.pangtudy.conferenceapi.entity.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.data.relational.core.query.Criteria.where;
import static org.springframework.data.relational.core.query.Query.query;

@Repository
@RequiredArgsConstructor
public class CustomScheduleRepositoryImpl implements CustomScheduleRepository {
    private final R2dbcEntityTemplate r2dbcTemplate;

    @Override
    public Mono<Schedule> findWithParticipantsById(Long id) {
        return r2dbcTemplate.selectOne(query(where("id").is(id)), Schedule.class)
                .flatMap(schedule -> r2dbcTemplate.select(query(where("schedule_id").is(id)), Participant.class)
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
        return r2dbcTemplate.select(query(where("year").is(year)), Schedule.class)
                .flatMap(schedule -> r2dbcTemplate.select(query(where("schedule_id").is(schedule.getId())), Participant.class)
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

    @Override
    public Mono<Void> deleteWithParticipantById(long id) {
        return r2dbcTemplate.delete(query(where("id").is(id)), Schedule.class)
                .doAfterTerminate(() -> r2dbcTemplate.delete(query(where("schedule_id").is(id)), Participant.class))
                .cast(Void.class);
    }

    private Mono<Schedule> insertWithParticipant(Schedule schedule) {
        return r2dbcTemplate.insert(schedule)
                .flatMap(s ->
                        Flux.concat(schedule.getParticipants().stream()
                                .map(participant -> r2dbcTemplate.insert(Participant.of(schedule.getId(), participant.getUserEmail(), participant.getUserName())))
                                .collect(Collectors.toList()))
                                .collectList()
                                .map(participants -> {
                                    s.setParticipants(participants);
                                    return s;
                                })
                );
    }

    private Mono<Schedule> updateWithParticipant(Schedule schedule) {
        return r2dbcTemplate.update(schedule)
                .flatMap(findSchedule -> Flux.concat(schedule.getParticipants().stream()
                                .map(participant -> this.selectOneByScheduleIdAndUserEmail(schedule.getId(), participant))
                                .collect(Collectors.toList()))
                        .collectList()
                        .map(participants -> {
                            this.deleteByScheduleIdAndIdNotIn(schedule.getId(), participants.stream().map(Participant::getId).collect(Collectors.toList()));
                            findSchedule.setParticipants(participants);
                            return findSchedule;
                        })
                );
    }

    private Mono<Participant> selectOneByScheduleIdAndUserEmail(Long scheduleId, Participant participant) {
        return r2dbcTemplate.selectOne(query(where("user_email").is(participant.getUserEmail())
                        .and("schedule_id").is(scheduleId)), Participant.class)
                .flatMap(findParticipant -> r2dbcTemplate.update(Participant.of(findParticipant.getId(), scheduleId, participant.getUserEmail(), participant.getUserName())))
                .switchIfEmpty(r2dbcTemplate.insert(Participant.of(scheduleId, participant.getUserEmail(), participant.getUserName())));
    }

    private void deleteByScheduleIdAndIdNotIn(Long scheduleId, List<Long> ids) {
        r2dbcTemplate.delete(query(where("id")
                        .notIn(ids)
                        .and(where("schedule_id").is(scheduleId))), Participant.class)
                .subscribe();
    }
}
