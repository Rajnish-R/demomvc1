package demomvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import demomvc.entity.StudentEntity;

public interface StudentEntityRepository extends JpaRepository<StudentEntity, Integer>{

	
}
