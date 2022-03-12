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

    private String userEmail;
    private String userName;

    @Transient
    @JsonIgnore
    private Schedule schedule;

    public static Participant of(String userEmail, String userName) {
        return Participant.builder()
                .userEmail(userEmail)
                .userName(userName)
                .build();
    }

    public static Participant of(Long scheduleId, String userEmail, String userName) {
        return Participant.builder()
                .scheduleId(scheduleId)
                .userEmail(userEmail)
                .userName(userName)
                .build();
    }

    public static Participant of(Long id, Long scheduleId, String userEmail, String userName) {
        return Participant.builder()
                .id(id)
                .scheduleId(scheduleId)
                .userEmail(userEmail)
                .userName(userName)
                .build();
    }
}
