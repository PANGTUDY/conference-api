package com.pangtudy.conferenceapi.dto;

import com.pangtudy.conferenceapi.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDto {
    private Long id;
    private int year;
    private int month;
    private int day;
    private String title;
    private LocalTime startTime;
    private LocalTime endTime;
    private String writer;
    private int alarm;
    private String comment;

    public static ScheduleDto of(Schedule schedule) {
        return ScheduleDto.builder()
                .id(schedule.getId())
                .year(schedule.getYear())
                .month(schedule.getMonth())
                .day(schedule.getDay())
                .title(schedule.getTitle())
                .startTime(schedule.getStartTime())
                .endTime(schedule.getEndTime())
                .writer(schedule.getWriter())
                .alarm(schedule.getAlarm())
                .comment(schedule.getComment())
                .build();
    }
}
