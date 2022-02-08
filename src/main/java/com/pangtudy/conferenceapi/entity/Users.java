package com.pangtudy.conferenceapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Table(value = "user_info")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Users {
    @Id
    @JsonIgnore
    private Long id;

    private String name;
    private String email;

    @Transient
    @JsonIgnore
    private List<ParticipantInfo> participantInfos;

    public static Users of(String name, String email) {
        return Users.builder()
                .name(name)
                .email(email)
                .build();
    }
}
