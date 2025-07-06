package com.fitnessApplication.ww.controller;

import com.fitnessApplication.ww.entity.Workouts;
import com.fitnessApplication.ww.service.WorkoutsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workouts")
public class WorkoutsController {

    @Autowired
    private WorkoutsService workoutsService;

    @PostMapping
    public Workouts createWorkout(@RequestBody Workouts workout) {
        return workoutsService.createWorkout(workout);
    }

    @GetMapping("/{id}")
    public Workouts getWorkoutById(@PathVariable Integer id) {
        return workoutsService.getWorkoutById(id);
    }

    @GetMapping
    public List<Workouts> getAllWorkouts() {
        return workoutsService.getAllWorkouts();
    }

    @PutMapping("/{id}")
    public Workouts updateWorkout(@PathVariable Integer id, @RequestBody Workouts workoutDetails) {
        return workoutsService.updateWorkout(id, workoutDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteWorkout(@PathVariable Integer id) {
        workoutsService.deleteWorkout(id);
    }
}