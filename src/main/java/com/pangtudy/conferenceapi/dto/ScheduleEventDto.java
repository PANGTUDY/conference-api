package com.pangtudy.conferenceapi.dto;

import com.pangtudy.conferenceapi.core.constants.ScheduleEventType;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class ScheduleEventDto implements Serializable {
    private ScheduleEventType type;
    private ScheduleDto schedule;
}
