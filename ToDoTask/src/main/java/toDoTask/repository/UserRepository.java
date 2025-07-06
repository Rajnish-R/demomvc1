package toDoTask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import toDoTask.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String>{
	
	
}