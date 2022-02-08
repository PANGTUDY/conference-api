package com.pangtudy.conferenceapi.repository;

import com.pangtudy.conferenceapi.entity.Schedule;
import com.pangtudy.conferenceapi.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.LocalTime;

@Repository
@RequiredArgsConstructor
public class CustomScheduleRepositoryImpl implements CustomScheduleRepository {
    private final R2dbcEntityTemplate r2dbcEntityTemplate;

    // select * from schedule where ID=18;
    // select u.name, u.email from participant_info p inner join user_info u on p.user_id = u.id where p.schedule_id = 18;
    @Override
    public Mono<Schedule> findWithParticipantsById(Long id) {
        String query = "SELECT * FROM SCHEDULE WHERE ID = :id";

        return r2dbcEntityTemplate.getDatabaseClient().sql(query)
                .bind("id", id)
                .fetch()
                .first()
                .flatMap(schedule -> {
                    String query2 = "SELECT u.NAME, u.EMAIL FROM PARTICIPANT_INFO as p LEFT OUTER JOIN USER_INFO as u ON p.USER_ID = u.ID WHERE p.SCHEDULE_ID = :id";

                    return r2dbcEntityTemplate.getDatabaseClient().sql(query2)
                            .bind("id", id)
                            .fetch()
                            .all()
                            .map(user -> Users.of((String) user.get("NAME"), (String) user.get("EMAIL")))
                            .collectList()
                            .map(users -> Schedule.builder()
                                    .id(Long.valueOf((Integer) schedule.get("ID")))
                                    .year(((BigDecimal) schedule.get("YEAR")).intValue())
                                    .month(((BigDecimal) schedule.get("MONTH")).intValue())
                                    .day(((BigDecimal) schedule.get("DAY")).intValue())
                                    .title((String) schedule.get("TITLE"))
                                    .startTime((LocalTime) schedule.get("START_TIME"))
                                    .endTime((LocalTime) schedule.get("END_TIME"))
                                    .writer((String) schedule.get("WRITER"))
                                    .alarm((Integer) schedule.get("ALARM"))
                                    .comment((String) schedule.get("COMMENT"))
                                    .participants(users)
                                    .build());
                });
    }
}
