package com.redis.temporal.model;

import com.redis.om.spring.annotations.Document;
import com.redis.om.spring.annotations.Indexed;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.*;
import java.util.Date;

@Data
@Builder
@RequiredArgsConstructor(staticName = "of")
@NoArgsConstructor(force = true)
@Document
public class Temporal {
  @Id
  @NonNull
  private String id;

  @Indexed
  @NonNull
  private LocalDate localDate;

  @Indexed
  @NonNull
  private LocalDateTime localDateTime;

  @Indexed
  @NonNull
  private Date date;

  @Indexed
  @NonNull
  private Instant instant;

  @Indexed
  @NonNull
  private OffsetDateTime localOffsetDateTime;

  @Indexed
  @NonNull
  private YearMonth yearMonth;
}
