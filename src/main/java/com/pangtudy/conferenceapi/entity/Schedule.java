package com.pangtudy.conferenceapi.entity;

import com.pangtudy.conferenceapi.dto.ScheduleDto;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalTime;
import java.util.List;

@Table
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Schedule {
    @Id
    Long id;
    Integer year;
    Integer month;
    Integer day;
    String title;
    LocalTime startTime;
    LocalTime endTime;
    String writer;

    @Transient
    List<Users> participants;
    Integer alarm;
    String comment;

    public static Schedule of(ScheduleDto scheduleDto) {
        return new Schedule(scheduleDto.getId(),
                scheduleDto.getYear(),
                scheduleDto.getMonth(),
                scheduleDto.getDay(),
                scheduleDto.getTitle(),
                scheduleDto.getStartTime(),
                scheduleDto.getEndTime(),
                scheduleDto.getWriter(),
                scheduleDto.getParticipants(),
                scheduleDto.getAlarm(),
                scheduleDto.getComment());
    }

}
