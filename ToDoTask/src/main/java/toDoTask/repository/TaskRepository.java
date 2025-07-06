package toDoTask.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import toDoTask.entity.TaskEntity;

public interface TaskRepository extends JpaRepository<TaskEntity, Integer>{

	public List<TaskEntity> findByEmail(String email);
}
