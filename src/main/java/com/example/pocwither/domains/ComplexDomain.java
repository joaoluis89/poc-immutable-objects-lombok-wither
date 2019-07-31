package com.example.pocwither.domains;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Wither;

@Getter
@Wither
@Builder
public final class ComplexDomain {
  private final SimpleDomain data1;
  private final SimpleDomain data2;
}
