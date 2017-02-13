package com.example.spring;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author norris.shelton
 */
public class Main {

    public static void main(String[] args) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        {
            JobLauncher jobLauncher = context.getBean("jobLauncher", JobLauncher.class);
            Job job = context.getBean("myJob1", Job.class);

            JobExecution execution = jobLauncher.run(job, new JobParameters());
            System.out.println("Job Exit Status : " + execution.getStatus());
        }
    }
}
