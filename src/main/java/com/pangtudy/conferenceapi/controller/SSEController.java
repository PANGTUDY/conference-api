package com.pangtudy.conferenceapi.controller;

import com.pangtudy.conferenceapi.core.channel.ScheduleChannel;
import com.pangtudy.conferenceapi.dto.SSEAuthDto;
import com.pangtudy.conferenceapi.dto.ScheduleEventDto;
import com.pangtudy.conferenceapi.service.SSEService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sse")
@RequiredArgsConstructor
public class SSEController {
	private final ScheduleChannel scheduleChannel;
	private final SSEService sseService;

	@GetMapping(value = "/auth")
	public Mono<SSEAuthDto> auth() {
		return sseService.auth();
	}

	@GetMapping(value = "/schedule/connect", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<ScheduleEventDto> connectScheduleSSE(
			@RequestParam(name = "sse-token") String sseAuthToken
	) {
		return sseService.validateSseAuthToken(sseAuthToken)
				.flatMapMany(result -> {
					if (result) {
						return scheduleChannel.asFlux();
					}
					throw new IllegalArgumentException();
				});
	}
}
