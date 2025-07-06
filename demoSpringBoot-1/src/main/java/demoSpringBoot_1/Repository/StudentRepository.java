package demoSpringBoot_1.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import demoSpringBoot_1.Entity.Student;
import jakarta.transaction.Transactional;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	List<Student> getAllByAge(int age);
	
//	List<Student> getAllByName(String name); //without using HQL query
	
	@Query("From Student where name=:name")
	List<Student> getAllByName(String name);
	
	
	@Query("From Student where age=:age")
	List<Student> getStudentByAge(int age);
	
	
	@Query("From Student where age>:age")
	List<Student> getAllGreaterAge(int age);

	@Query("From Student where age<:age")
	List<Student> getAllLesserAge(int age);
	
	@Query("From Student where name=:name and age=:age")
	List<Student> getByNameAndAge(String name, int age);
	
	
	
	@Query("from Student where age=:age")
	public List<Student> getByAge(int age);
	
	
	//To perform any DML operation
	@Query("delete from Student where id=:id")
	@Modifying
	@Transactional
	void deletebyid(int id);
	
//	Same thing you have to perform the update operation updatebyid or name or age task...
	
	@Query("Update Student set name=:name where id=:id")
	@Modifying
	@Transactional
	void updateNamebyIdd(String name, int id);
	
	
	@Query("Update Student set age=:age where name=:name")
	@Modifying
	@Transactional
	void updateAgebyNamee(int age, String name);
	
	
	@Query("Update Student set name=:name where age=:age")
	@Modifying
	@Transactional
	void updateNamebyAge(String name, int age);
}
