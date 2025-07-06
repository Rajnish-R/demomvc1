package com.fitnessApplication.ww.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String username;
	private int age;
   
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Goals> goals;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Workouts> workouts;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Goals> getGoals() {
		return goals;
	}

	public void setGoals(List<Goals> goals) {
		this.goals = goals;
	}

	public List<Workouts> getWorkouts() {
		return workouts;
	}

	public void setWorkouts(List<Workouts> workouts) {
		this.workouts = workouts;
	}
}