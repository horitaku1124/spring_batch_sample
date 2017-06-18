package com.example.spring;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.spring.repository.SampleTableRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BatchTests3 {
  @Autowired
  private SampleTableRepository sampleTableRepo;
  @Bean(destroyMethod = "shutdown")
  public EmbeddedDatabase dataSource() {
      return new EmbeddedDatabaseBuilder().
              setType(EmbeddedDatabaseType.H2).
              addScript("db-schema.sql").
              addScript("db-test-data.sql").
              build();
  }
  @Before
  public void setup() {
  }
  
  @Test
  public void contextLoads() {
    System.out.println(" -- " + new Exception().getStackTrace()[0].getMethodName());
    assertEquals(1, sampleTableRepo.findAll().size());
  }
}
