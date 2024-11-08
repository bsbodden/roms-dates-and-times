package com.redis.temporal;

import com.redis.om.spring.annotations.EnableRedisDocumentRepositories;
import com.redis.temporal.model.Temporal;
import com.redis.temporal.repository.TemporalRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableRedisDocumentRepositories
public class RomsDatesAndTimesApplication {

  @Bean
  CommandLineRunner loadTestData(TemporalRepository repository) {
    return args -> {
      List<Temporal> temporals = new ArrayList<>();
      LocalDateTime baseDateTime = LocalDateTime.of(1999, 12, 31, 0, 0);

      for (int i = 0; i < 10; i++) {
        LocalDate localDate = baseDateTime.plusYears(i).toLocalDate();
        LocalDateTime localDateTime = baseDateTime.plusYears(i);
        OffsetDateTime localOffsetDateTime = baseDateTime.plusYears(i).atOffset(ZoneOffset.UTC);
        Date date = Date.from(baseDateTime.plusYears(i).toInstant(ZoneOffset.UTC));
        Instant instant = baseDateTime.plusYears(i).toInstant(ZoneOffset.UTC);
        YearMonth yearMonth = YearMonth.of(1999 + i, 12);

        Temporal ks = Temporal.builder().id("temporal_" + i).localDate(localDate).localDateTime(localDateTime)
            .localOffsetDateTime(localOffsetDateTime).date(date).instant(instant).yearMonth(yearMonth).build();

        temporals.add(ks);
      }

      repository.saveAll(temporals);
    };
  }

  public static void main(String[] args) {
    SpringApplication.run(RomsDatesAndTimesApplication.class, args);
  }

}
