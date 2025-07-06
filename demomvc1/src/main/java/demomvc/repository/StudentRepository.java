package demomvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demomvc.entity.Student;
import demomvc.entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	List<Student> findByName(String name);
	List<Student> findByAge(int age);

}
