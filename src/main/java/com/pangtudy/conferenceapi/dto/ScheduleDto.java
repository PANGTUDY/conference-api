package com.pangtudy.conferenceapi.dto;

import com.pangtudy.conferenceapi.entity.Schedule;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ScheduleDto {
    private Long id;
    private String title;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String writer;
    private Integer alarm;
    private String comment;

    public static ScheduleDto of(Schedule schedule) {
        return ScheduleDto.builder()
                .id(schedule.getId())
                .title(schedule.getTitle())
                .startTime(schedule.getStartTime())
                .endTime(schedule.getEndTime())
                .writer(schedule.getWriter())
                .alarm(schedule.getAlarm())
                .comment(schedule.getComment())
                .build();
    }
}
