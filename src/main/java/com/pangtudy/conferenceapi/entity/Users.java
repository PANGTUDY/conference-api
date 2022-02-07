package com.pangtudy.conferenceapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(value = "User")
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Users {
    @Id
    private Long id;
    private String name;
    private String email;
}
