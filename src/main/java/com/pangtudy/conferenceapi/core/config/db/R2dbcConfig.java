package com.pangtudy.conferenceapi.core.config.db;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@Configuration
@EnableR2dbcRepositories
public class R2dbcConfig extends AbstractR2dbcConfiguration {

    @Override
    public ConnectionFactory connectionFactory() {
        return null;
    }
//
//    @Override
//    public List<Object> getCustomConverters() {
//        List<Object> converterList = new ArrayList<>();
//        converterList.add(new ScheduleReadConverter());
//        return converterList;
//    }
}
