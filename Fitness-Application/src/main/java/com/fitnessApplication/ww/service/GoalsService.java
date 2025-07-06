package com.fitnessApplication.ww.service;

import java.util.List;

import com.fitnessApplication.ww.entity.Goals;

public interface GoalsService {

	Goals createGoal(Goals goal);
	Goals getGoalById(Integer gid);
	List<Goals> getAllGoals();
	Goals updateGoal(Integer gid, Goals goalDetails);
	void deleteGoal(Integer gid);
	
}
