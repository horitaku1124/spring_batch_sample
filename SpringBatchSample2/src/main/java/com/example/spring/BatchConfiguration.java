package com.example.spring;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
  @Autowired
  @Qualifier("myBatchJob")
  private Tasklet myBatchJob;

  @Autowired
  private JobBuilderFactory jobBuilderFactory;

  @Autowired
  private StepBuilderFactory stepBuilderFactory;

  @Bean
  public Step step1() {
    return stepBuilderFactory.get("step1")
            .tasklet(myBatchJob)
            .build();
  }
  @Bean
  public Job job(Step step1) throws Exception {
    return jobBuilderFactory.get("job")
            .incrementer(new RunIdIncrementer())
            .listener(listener())
            .start(step1)
            .build();
  }

  @Bean
  public JobExecutionListener listener() {
    return new JobListener();
  }
  @Bean
  public ResourcelessTransactionManager transactionManager() {
    return new ResourcelessTransactionManager();
  }

  @Bean
  public JobRepository jobRepository(ResourcelessTransactionManager transactionManager) throws Exception {
    MapJobRepositoryFactoryBean mapJobRepositoryFactoryBean = new MapJobRepositoryFactoryBean(transactionManager);
    mapJobRepositoryFactoryBean.setTransactionManager(transactionManager);
    return mapJobRepositoryFactoryBean.getObject();
  }

  @Bean
  public SimpleJobLauncher jobLauncher(JobRepository jobRepository) {
    SimpleJobLauncher simpleJobLauncher = new SimpleJobLauncher();
    simpleJobLauncher.setJobRepository(jobRepository);
    return simpleJobLauncher;
  }
}
