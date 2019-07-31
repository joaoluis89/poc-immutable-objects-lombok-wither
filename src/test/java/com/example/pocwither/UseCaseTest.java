package com.example.pocwither;

import static org.junit.Assert.*;

import com.example.pocwither.domains.ComplexDomain;
import com.example.pocwither.domains.SimpleDomain;
import java.time.LocalDate;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@Slf4j
@RunWith(MockitoJUnitRunner.class)
public class UseCaseTest {

  private UseCase useCase;
  @Before
  public void setUp() throws Exception {
    useCase = new UseCase();
  }

  @Test
  public void execute() {
    final ComplexDomain complexDomain = ComplexDomain.builder()
        .data1(SimpleDomain.builder()
            .valueInCents(100)
            .createdAt(LocalDate.now())
            .build())
        .data2(SimpleDomain.builder()
            .valueInCents(300)
            .createdAt(LocalDate.now().plusDays(1))
            .build())
        .build();

    ComplexDomain anotherComplexDomain = useCase.execute(complexDomain);

    assertNotEquals(complexDomain, anotherComplexDomain);
    assertNotEquals(complexDomain.getData1(), anotherComplexDomain.getData1());
    assertNotEquals(complexDomain.getData1().getCreatedAt(), anotherComplexDomain.getData1().getCreatedAt());
    assertNotEquals(complexDomain.getData1().getValueInCents(), anotherComplexDomain.getData1().getValueInCents());
    assertEquals(complexDomain.getData2(), anotherComplexDomain.getData2());

    log.info("Complex domain hashcode {}, Another complex domain hashcode {}", complexDomain.hashCode(), anotherComplexDomain.hashCode());
    log.info("Simple data 1 hashcode {}, another simple data 1 hashcode {}", complexDomain.getData1().hashCode(), anotherComplexDomain.getData1().hashCode());
    log.info("Simple data 2 hashcode {}, another simple data 2 hashcode {}", complexDomain.getData2().hashCode(), anotherComplexDomain.getData2().hashCode());
  }
}