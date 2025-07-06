package com.fitnessApplication.ww.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fitnessApplication.ww.entity.Goals;

public interface GoalsRepository extends JpaRepository<Goals, Integer>{
	
}
