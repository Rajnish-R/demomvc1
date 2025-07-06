package com.fitnessApplication.ww.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitnessApplication.ww.entity.Workouts;
import com.fitnessApplication.ww.repository.WorkoutsRepository;

@Service
public class WorkoutsServiceImpl implements WorkoutsService{

	@Autowired
	private WorkoutsRepository workoutsRepository;
	
	@Override
	public Workouts createWorkout(Workouts workout)
	{
		return workoutsRepository.save(workout);
	}
	
	@Override
	public Workouts getWorkoutById(Integer wid) {
		return workoutsRepository.findById(wid).orElse(null);
	}
	
	@Override
	public List<Workouts> getAllWorkouts(){
		return workoutsRepository.findAll();
	}
	
	@Override
	public Workouts updateWorkout(Integer wid, Workouts workoutDetails) {
		Optional<Workouts> optional = workoutsRepository.findById(wid);
		if(optional.isPresent())
		{	
			Workouts workout = optional.get();
			workout.setWorkoutName(workoutDetails.getWorkoutName());
			workout.setTimeDuration(workoutDetails.getTimeDuration());
			workout.setUser(workoutDetails.getUser());
			return workoutsRepository.save(workout);
		}
		return null;
	}
	
	@Override
	public void deleteWorkout(Integer wid) {
		workoutsRepository.deleteById(wid);
	}
}