package com.example.spring.repository;

import com.example.spring.entity.SampleTableEntity;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface SampleTableRepository extends JpaRepository<SampleTableEntity, Long> {}
