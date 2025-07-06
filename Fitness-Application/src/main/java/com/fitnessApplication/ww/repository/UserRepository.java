package com.fitnessApplication.ww.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fitnessApplication.ww.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
