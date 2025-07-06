package com.fitnessApplication.ww.controller;

import com.fitnessApplication.ww.entity.Goals;
import com.fitnessApplication.ww.service.GoalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/goals")
public class GoalsController {

    @Autowired
    private GoalsService goalsService;

    @PostMapping
    public Goals createGoal(@RequestBody Goals goal) {
        return goalsService.createGoal(goal);
    }

    @GetMapping("/{id}")
    public Goals getGoalById(@PathVariable Integer id) {
        return goalsService.getGoalById(id);
    }

    @GetMapping
    public List<Goals> getAllGoals() {
        return goalsService.getAllGoals();
    }

    @PutMapping("/{id}")
    public Goals updateGoal(@PathVariable Integer id, @RequestBody Goals goalDetails) {
        return goalsService.updateGoal(id, goalDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteGoal(@PathVariable Integer id) {
        goalsService.deleteGoal(id);
    }
}