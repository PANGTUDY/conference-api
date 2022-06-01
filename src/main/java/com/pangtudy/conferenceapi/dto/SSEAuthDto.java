package com.pangtudy.conferenceapi.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SSEAuthDto {
	private String sseAuthToken;
	private LocalDateTime expireDate;
}
