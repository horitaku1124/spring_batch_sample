package com.example.spring;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.spring.entity.SampleTableEntity;
import com.example.spring.repository.SampleTableRepository;

@SpringBootTest
public class BatchTests2 {
  @Mock
  private SampleTableRepository sampleTableRepo;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }
  
  @SuppressWarnings("serial")
  @Test
  public void contextLoads() {
    List<SampleTableEntity> list = new ArrayList<SampleTableEntity>() {{
        add(new SampleTableEntity() {{
            setId(1);
            setName("test");
            setStatus(10);
          }
        });
      }
    };
    when(sampleTableRepo.findAll()).thenReturn(list); // (1)
    
    System.out.println(" -- " + new Exception().getStackTrace()[0].getMethodName());
    System.out.println(sampleTableRepo.findAll().size());
  }
}
