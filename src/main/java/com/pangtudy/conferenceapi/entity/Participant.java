package com.pangtudy.conferenceapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Participant {
    @Id
    @JsonIgnore
    private Long id;

    @JsonIgnore
    private Long scheduleId;

    private String email;
    private String name;

    @Transient
    @JsonIgnore
    private Schedule schedule;

    public static Participant of(String email, String name) {
        return Participant.builder()
                .email(email)
                .name(name)
                .build();
    }

    public static Participant of(Long scheduleId, String email, String name) {
        return Participant.builder()
                .scheduleId(scheduleId)
                .email(email)
                .name(name)
                .build();
    }

    public static Participant of(Long id, Long scheduleId, String email, String name) {
        return Participant.builder()
                .id(id)
                .scheduleId(scheduleId)
                .email(email)
                .name(name)
                .build();
    }
}
