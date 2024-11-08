package com.redis.temporal.controller;

import com.redis.om.spring.search.stream.EntityStream;
import com.redis.om.spring.search.stream.SearchStream;
import com.redis.temporal.model.Temporal;
import com.redis.temporal.model.Temporal$;
import com.redis.temporal.repository.TemporalRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/temporal/")
public class TemporalController {
  private final TemporalRepository repo;
  private final EntityStream entityStream;

  public TemporalController(TemporalRepository repo, EntityStream entityStream) {
    this.repo = repo;
    this.entityStream = entityStream;
  }

  // LocalDate - Expected result: temporals with IDs within specified range
  @GetMapping("localDateBetween")
  public List<Temporal> getTemporalByLocalDateBetween() {
    LocalDate start = LocalDate.of(2000, 1, 1);
    LocalDate end = LocalDate.of(2004, 1, 1);
    return repo.findByLocalDateBetween(start, end);  // Expected IDs: temporal_1 to temporal_4
  }

  @GetMapping("localDateGreaterThan")
  public List<Temporal> getTemporalByLocalDateGreaterThan() {
    LocalDate date = LocalDate.of(2005, 1, 1);
    return repo.findByLocalDateGreaterThan(date);  // Expected IDs: temporal_6 to temporal_9
  }

  // LocalDate Less Than - Expected result: temporals with dates before specified date
  @GetMapping("localDateLessThan")
  public List<Temporal> getTemporalByLocalDateLessThan() {
    LocalDate date = LocalDate.of(2005, 1, 1);
    return repo.findByLocalDateLessThan(date);  // Expected IDs: temporal_0 to temporal_5
  }

  // LocalDate Greater Than or Equal - Expected result: temporals with dates on or after specified date
  @GetMapping("localDateGreaterThanEqual")
  public List<Temporal> getTemporalByLocalDateGreaterThanEqual() {
    LocalDate date = LocalDate.of(2005, 1, 1);
    return repo.findByLocalDateGreaterThanEqual(date);  // Expected IDs: temporal_6 to temporal_9
  }

  // LocalDate Less Than or Equal - Expected result: temporals with dates on or before specified date
  @GetMapping("localDateLessThanEqual")
  public List<Temporal> getTemporalByLocalDateLessThanEqual() {
    LocalDate date = LocalDate.of(2004, 1, 1);
    return repo.findByLocalDateLessThanEqual(date);  // Expected IDs: temporal_0 to temporal_4
  }

  @GetMapping("localDateTimeBetween")
  public List<Temporal> getTemporalByLocalDateTimeBetween() {
    LocalDateTime start = LocalDateTime.of(2000, 1, 1, 0, 0);
    LocalDateTime end = LocalDateTime.of(2004, 1, 1, 0, 0);
    return repo.findByLocalDateTimeBetween(start, end);  // Expected IDs: temporal_1 to temporal_4
  }

  @GetMapping("localDateTimeGreaterThan")
  public List<Temporal> getTemporalByLocalDateTimeGreaterThan() {
    LocalDateTime dateTime = LocalDateTime.of(2005, 1, 1, 0, 0);
    return repo.findByLocalDateTimeGreaterThan(dateTime);  // Expected IDs: temporal_6 to temporal_9
  }

  // LocalDateTime Less Than - Expected result: temporals with LocalDateTime before specified dateTime
  @GetMapping("localDateTimeLessThan")
  public List<Temporal> getTemporalByLocalDateTimeLessThan() {
    LocalDateTime dateTime = LocalDateTime.of(2005, 1, 1, 0, 0);
    return repo.findByLocalDateTimeLessThan(dateTime);  // Expected IDs: temporal_0 to temporal_5
  }

  // LocalDateTime Greater Than or Equal - Expected result: temporals with LocalDateTime on or after specified dateTime
  @GetMapping("localDateTimeGreaterThanEqual")
  public List<Temporal> getTemporalByLocalDateTimeGreaterThanEqual() {
    LocalDateTime dateTime = LocalDateTime.of(2005, 1, 1, 0, 0);
    return repo.findByLocalDateTimeGreaterThanEqual(dateTime);  // Expected IDs: temporal_6 to temporal_9
  }

  // LocalDateTime Less Than or Equal - Expected result: temporals with LocalDateTime on or before specified dateTime
  @GetMapping("localDateTimeLessThanEqual")
  public List<Temporal> getTemporalByLocalDateTimeLessThanEqual() {
    LocalDateTime dateTime = LocalDateTime.of(2004, 1, 1, 0, 0);
    return repo.findByLocalDateTimeLessThanEqual(dateTime);  // Expected IDs: temporal_0 to temporal_4
  }

  // LocalDate Between using EntityStream API
  @GetMapping("localDateBetweenStream")
  public List<Temporal> getTemporalByLocalDateBetweenStream() {
    SearchStream<Temporal> stream = entityStream.of(Temporal.class);

    LocalDate startDate = LocalDate.of(2000, 1, 1);
    LocalDate endDate = LocalDate.of(2004, 1, 1);

    return stream
        .filter(Temporal$.LOCAL_DATE.between(startDate, endDate))
        .collect(Collectors.toList());  // Expected IDs: temporal_1 to temporal_4
  }

}

