package com.example.pocwither.domains;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Wither;
import org.springframework.data.annotation.Id;

@Getter
@Wither
@Builder
public final class ComplexDomain {
  @Id
  private final String id;
  private final SimpleDomain data1;
  private final SimpleDomain data2;
  private final SimpleDomain data3;
}
