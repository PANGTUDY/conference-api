package com.pangtudy.conferenceapi.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import com.pangtudy.conferenceapi.dto.SSEAuthDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import nonapi.io.github.classgraph.json.Id;

import org.springframework.data.relational.core.mapping.Table;

@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class SSEAuthToken {
	@Id
	private String sseAuthToken = UUID.randomUUID().toString();

	private LocalDateTime expireDate = LocalDateTime.now();

	public boolean isExpired() {
		return this.expireDate.isAfter(LocalDateTime.now());
	}

	public SSEAuthDto toDto() {
		return new SSEAuthDto(this.sseAuthToken, this.expireDate);
	}
}
