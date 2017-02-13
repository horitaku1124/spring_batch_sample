package com.example.spring;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.apache.log4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import com.example.spring.entity.SampleTableEntity;

public class MyBatch implements Tasklet {
	static Logger logger = Logger.getLogger("MyBatch");
	
    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

	public RepeatStatus execute(StepContribution arg0, ChunkContext arg1)
			throws Exception {
		SampleTableEntity A = new SampleTableEntity();
		A.setName("vvvv");
		A.setStatus(100);
		entityManager.persist(A);

		System.out.println("Created SampleTableEntity=" + A.getId());
		return RepeatStatus.FINISHED;
	}
}