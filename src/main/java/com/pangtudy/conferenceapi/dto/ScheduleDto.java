package com.pangtudy.conferenceapi.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ScheduleDto {
    private int year;
    private int month;
    private int day;
}
