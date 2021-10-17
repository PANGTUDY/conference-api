package com.pangtudy.conferenceapi.entity;

import com.pangtudy.conferenceapi.dto.ScheduleDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Schedule {
    @Id
    Long id;
    String title;
    LocalDateTime startTime;
    LocalDateTime endTime;
    String writer;
    Integer alarm;
    String comment;

    public static Schedule of(ScheduleDto scheduleDto) {
        return new Schedule(scheduleDto.getId(), scheduleDto.getTitle(), scheduleDto.getStartTime(), scheduleDto.getEndTime(), scheduleDto.getWriter(), scheduleDto.getAlarm(), scheduleDto.getComment());
    }
}
