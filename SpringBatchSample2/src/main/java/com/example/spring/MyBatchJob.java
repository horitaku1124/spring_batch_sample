package com.example.spring;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.apache.log4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.spring.entity.SampleTableEntity;
import com.example.spring.repository.SampleTableRepository;
import org.springframework.stereotype.Component;

@Component
public class MyBatchJob implements Tasklet {
	static Logger logger = Logger.getLogger("MyBatch");
	
    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

	@Autowired
    private SampleTableRepository sampleTableRepo;

	public RepeatStatus execute(StepContribution arg0, ChunkContext arg1)
			throws Exception {
		SampleTableEntity sampleTable = new SampleTableEntity();
		sampleTable.setName("test name");
		sampleTable.setStatus(100);
		entityManager.persist(sampleTable);
		
		List<SampleTableEntity> list = sampleTableRepo.findAll();

		System.out.println("Created SampleTableEntity=" + sampleTable.getId());
		System.out.println("SampleTableEntity.size=" + list.size());
		return RepeatStatus.FINISHED;
	}
}