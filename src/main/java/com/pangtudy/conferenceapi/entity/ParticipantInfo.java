package com.pangtudy.conferenceapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table
@Getter
@Setter
@AllArgsConstructor
@ToString
public class ParticipantInfo {
    @Id
    private Long id;
    private Schedule schedule;
    private Users user;
}
