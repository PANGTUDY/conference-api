package com.pangtudy.conferenceapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Table(value = "user_info")
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Users {
    @Id
    private Long id;
    private String name;
    private String email;

    @Transient
    private List<ParticipantInfo> participantInfos;
}
