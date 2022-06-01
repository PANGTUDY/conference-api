package com.pangtudy.conferenceapi.service;

import com.pangtudy.conferenceapi.dto.SSEAuthDto;
import com.pangtudy.conferenceapi.entity.SSEAuthToken;
import com.pangtudy.conferenceapi.repository.SSEAuthTokenRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SSEService {
	private final SSEAuthTokenRepository sseRepository;

	@Transactional
	public Mono<SSEAuthDto> auth() {
		return sseRepository.save(SSEAuthToken.builder().build())
				.map(SSEAuthToken::toDto);
	}

	public Mono<Boolean> validateSseAuthToken(String sseAuthToken) {
		return sseRepository.findById(sseAuthToken)
				.map(SSEAuthToken::isExpired)
				.switchIfEmpty(Mono.just(false));
	}
}
