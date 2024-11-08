package com.redis.temporal.repository;

import com.redis.om.spring.repository.RedisDocumentRepository;
import com.redis.temporal.model.Temporal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface TemporalRepository extends RedisDocumentRepository<Temporal, String> {

  // LocalDate
  List<Temporal> findByLocalDateBetween(LocalDate start, LocalDate end);

  List<Temporal> findByLocalDateGreaterThan(LocalDate date);

  List<Temporal> findByLocalDateLessThan(LocalDate date);

  List<Temporal> findByLocalDateGreaterThanEqual(LocalDate date);

  List<Temporal> findByLocalDateLessThanEqual(LocalDate date);

  // LocalDateTime
  List<Temporal> findByLocalDateTimeBetween(LocalDateTime start, LocalDateTime end);

  List<Temporal> findByLocalDateTimeGreaterThan(LocalDateTime dateTime);

  List<Temporal> findByLocalDateTimeLessThan(LocalDateTime dateTime);

  List<Temporal> findByLocalDateTimeGreaterThanEqual(LocalDateTime dateTime);

  List<Temporal> findByLocalDateTimeLessThanEqual(LocalDateTime dateTime);
}

