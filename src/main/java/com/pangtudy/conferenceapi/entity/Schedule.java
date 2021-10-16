package com.pangtudy.conferenceapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table
@Getter
@AllArgsConstructor
@ToString
public class Schedule {
    @Id
    private final Long id;
    private final Integer year;
    private final Integer month;
    private final Integer day;
}
