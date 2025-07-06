package com.fitnessApplication.ww.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fitnessApplication.ww.entity.Workouts;

public interface WorkoutsRepository extends JpaRepository<Workouts, Integer>{
	
}
