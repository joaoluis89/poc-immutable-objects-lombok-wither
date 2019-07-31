package com.example.pocwither;

import com.example.pocwither.domains.ComplexDomain;
import com.example.pocwither.domains.SimpleDomain;
import java.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@DataMongoTest
@RunWith(SpringRunner.class)
public class MongoIntegrationTest {

  public static final String COMPLEX_DOMAIN_COLLECTION = "complexDomainCollection";

  @Autowired
  private MongoTemplate mongoTemplate;

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
    ComplexDomain anotherComplexDomain =  mongoTemplate.save(complexDomain);

    Assert.assertNull(complexDomain.getId());
    Assert.assertNotNull(anotherComplexDomain);
    Assert.assertEquals(complexDomain.getData1(), anotherComplexDomain.getData1());
    Assert.assertEquals(complexDomain.getData2(), anotherComplexDomain.getData2());
  }

}
