package com.example.pocwither.domains;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Wither;

@Getter
@Wither
@Builder
public final class SimpleDomain {
  private final long valueInCents;
  private final LocalDate createdAt;

}
