package com.pangtudy.conferenceapi.core.channel;

import com.pangtudy.conferenceapi.dto.ScheduleEventDto;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;
import reactor.core.publisher.Sinks.Many;

@Component
public class ScheduleChannel {
    private final Many<ScheduleEventDto> scheduleEvents;

    public ScheduleChannel() {
        this.scheduleEvents = Sinks.many().multicast().directAllOrNothing();
    }
    public Many<ScheduleEventDto> getSink() {
        return this.scheduleEvents;
    }
    public Flux<ScheduleEventDto> asFlux() {
        return this.scheduleEvents.asFlux();
    }
}
