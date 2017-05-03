package com.example.spring.repository;

import com.example.spring.entity.SampleTableEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleTableRepository extends JpaRepository<SampleTableEntity, Long> {}
