package com.fitnessApplication.ww.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitnessApplication.ww.entity.Goals;
import com.fitnessApplication.ww.repository.GoalsRepository;

@Service
public class GoalsServiceImpl implements GoalsService{

	@Autowired
	private GoalsRepository goalsRepository;
	
	@Override
	public Goals createGoal(Goals goal) {
		return goalsRepository.save(goal);
	}
	
	@Override
	public Goals getGoalById(Integer gid)
	{
		return goalsRepository.findById(gid).orElse(null);
	}
	
	@Override
	public List<Goals> getAllGoals(){
		return goalsRepository.findAll();
	}
	
	@Override
	public Goals updateGoal(Integer gid, Goals goalDetails) {
		Optional<Goals> optional = goalsRepository.findById(gid);
		if(optional.isPresent())
		{
			Goals goal = optional.get();
			goal.setKg(goalDetails.getKg());
			goal.setUser(goalDetails.getUser());
			return goalsRepository.save(goal);
		}
		return null;
	}
	
	@Override
	public void deleteGoal(Integer gid) {
		goalsRepository.deleteById(gid);
	}
}