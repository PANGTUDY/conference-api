package com.pangtudy.conferenceapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

@Table
@Getter
@Setter
@AllArgsConstructor
@ToString
public class ParticipantInfo {
    @Id
    private Long id;

    private Long scheduleId;
    private Long userId;

    @Transient
    private Schedule schedule;

    @Transient
    private Users user;
}
