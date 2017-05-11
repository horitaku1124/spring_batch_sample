package com.example.spring;

import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    public static void main(String[] args) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
        SpringApplication.run(Main.class, args);
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        {
//            JobLauncher jobLauncher = context.getBean("jobLauncher", JobLauncher.class);
//            Job job = context.getBean("myJob1", Job.class);
//
//            JobExecution execution = jobLauncher.run(job, new JobParameters());
//            System.out.println("Job Exit Status : " + execution.getStatus());
//        }
    }
}
