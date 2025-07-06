package com.fitnessApplication.ww.service;

import java.util.List;

import com.fitnessApplication.ww.entity.Workouts;

public interface WorkoutsService {

	Workouts createWorkout(Workouts workout);
	Workouts getWorkoutById(Integer wid);
	List<Workouts> getAllWorkouts();
	Workouts updateWorkout(Integer wid, Workouts workoutDetails);
	void deleteWorkout(Integer wid);
	
}