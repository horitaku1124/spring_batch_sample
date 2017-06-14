package com.example.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.spring.repository.SampleTableRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBatchSample2ApplicationTests {

  @Autowired
  private SampleTableRepository sampleTableRepo;
  
  @Test
  public void contextLoads() {
    System.out.println(" -- " + new Exception().getStackTrace()[0].getMethodName());
    System.out.println(sampleTableRepo.findAll().size());
  }
}
