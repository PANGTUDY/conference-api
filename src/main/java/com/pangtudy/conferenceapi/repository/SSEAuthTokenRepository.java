package com.pangtudy.conferenceapi.repository;

import com.pangtudy.conferenceapi.entity.SSEAuthToken;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SSEAuthTokenRepository extends ReactiveCrudRepository<SSEAuthToken, String> {
}
