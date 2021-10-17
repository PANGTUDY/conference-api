package com.pangtudy.conferenceapi.entity.converter;

import com.pangtudy.conferenceapi.entity.Schedule;
import io.r2dbc.spi.Row;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

import java.util.Objects;

@ReadingConverter
public class ScheduleReadConverter implements Converter<Row, Schedule> {
    @Override
    public Schedule convert(Row row) {
        Schedule schedule = new Schedule(Objects.requireNonNull(row.get("id", Integer.class)).longValue(), 1, row.get("month", Integer.class), row.get("day", Integer.class));
        System.out.println("schedule = " + schedule);
        return schedule;
    }
}
