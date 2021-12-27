package com.pangtudy.conferenceapi.mock;

import com.pangtudy.conferenceapi.entity.Schedule;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalTime;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CalendarMock {
    private static List<Schedule> schedules = List.of(
            new Schedule(1L, 2020, 8, 31, "Test Title1", LocalTime.of(18, 0), LocalTime.of(21, 0), "박찬준", 0, "Test Commnet1"),
            new Schedule(2L, 2020, 9, 12, "Test Title2", LocalTime.of(20, 30), LocalTime.of(21, 30), "박찬준", 0, "Test Commnet2"),
            new Schedule(3L, 2020, 9, 19, "Test Title3", LocalTime.of(19, 30), LocalTime.of(21, 0), "원철황", 1, "Test Commnet3"),
            new Schedule(4L, 2020, 11, 29, "Test Title4", LocalTime.of(19, 0), LocalTime.of(21, 0), "박찬준", 0, "Test Commnet4"),
            new Schedule(5L, 2021, 2, 7, "Test Title5", LocalTime.of(18, 30), LocalTime.of(22, 0), "김민주", 1, "Test Commnet5"),
            new Schedule(6L, 2021, 5, 8, "Test Title6", LocalTime.of(18, 0), LocalTime.of(22, 0), "박찬준", 1, "Test Commnet6"),
            new Schedule(7L, 2021, 5, 10, "Test Title7", LocalTime.of(18, 30), LocalTime.of(20, 30), "박찬준", 0, "Test Commnet7"),
            new Schedule(8L, 2021, 5, 12, "Test Title8", LocalTime.of(21, 30), LocalTime.of(23, 30), "김민주", 1, "Test Commnet8"),
            new Schedule(9L, 2021, 8, 31, "Test Title9", LocalTime.of(21, 0), LocalTime.of(23, 0), "원철황", 0, "Test Commnet9"),
            new Schedule(10L, 2021, 9, 8, "Test Title10", LocalTime.of(22, 0), LocalTime.of(23, 0), "박찬준", 0, "Test Commnet10"),
            new Schedule(11L, 2021, 10, 11, "Test Title11", LocalTime.of(18, 30), LocalTime.of(20, 30), "박찬준", 1, "Test Commnet11"),
            new Schedule(12L, 2021, 12, 8, "Test Title12", LocalTime.of(18, 0), LocalTime.of(21, 0), "박찬준", 1, "Test Commnet12"),
            new Schedule(13L, 2021, 12, 21, "Test Title13", LocalTime.of(19, 30), LocalTime.of(21, 30), "원철황", 0, "Test Commnet13"),
            new Schedule(14L, 2021, 12, 24, "Test Title14", LocalTime.of(19, 30), LocalTime.of(21, 30), "김민주", 0, "Test Commnet14"),
            new Schedule(15L, 2022, 2, 15, "Test Title15", LocalTime.of(20, 0), LocalTime.of(22, 0), "박찬준", 0, "Test Commnet15"),
            new Schedule(16L, 2022, 3, 19, "Test Title16", LocalTime.of(20, 30), LocalTime.of(22, 30), "원철황", 1, "Test Commnet16"),
            new Schedule(17L, 2022, 3, 31, "Test Title17", LocalTime.of(21, 30), LocalTime.of(23, 30), "원철황", 0, "Test Commnet17"),
            new Schedule(18L, 2022, 4, 28, "Test Title18", LocalTime.of(18, 0), LocalTime.of(20, 0), "김민주", 0, "Test Commnet18"),
            new Schedule(19L, 2022, 5, 20, "Test Title19", LocalTime.of(19, 30), LocalTime.of(21, 30), "박찬준", 0, "Test Commnet19"),
            new Schedule(20L, 2022, 7, 1, "Test Title20", LocalTime.of(18, 0), LocalTime.of(20, 0), "박찬준", 1, "Test Commnet20")
    );

    public static Flux<Schedule> findSchedulesByYear(int year) {
        return Flux.fromIterable(schedules.stream()
                .filter(schedule -> schedule.getYear() == year)
                .collect(Collectors.toList()));
    }

    public static Mono<Schedule> findOneSchedule() {
        return Mono.just(schedules.get(new Random().nextInt(schedules.size())));
    }
}
