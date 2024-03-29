package com.example.pocwither;

import com.example.pocwither.domains.ComplexDomain;
import com.example.pocwither.domains.SimpleDomain;
import java.time.LocalDate;

public class UseCase {

  public ComplexDomain execute(ComplexDomain complexDomain) {
    final SimpleDomain data1 = complexDomain.getData1();
    return complexDomain
        .withData1(
            data1
                .withValueInCents(data1.getValueInCents() + 1000L)
                .withCreatedAt(data1.getCreatedAt().plusDays(3)))
        .withData3(SimpleDomain.builder()
            .createdAt(LocalDate.now())
            .build());
  }

}
