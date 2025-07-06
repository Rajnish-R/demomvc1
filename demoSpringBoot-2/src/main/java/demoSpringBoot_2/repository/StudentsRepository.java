package demoSpringBoot_2.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import demoSpringBoot_2.entity.Students;
import demoSpringBoot_2.entity.StudentsPk;
import jakarta.transaction.Transactional;

@Repository
public interface StudentsRepository extends JpaRepository<Students, StudentsPk>{
	
	List<Students> getAllByAge(int age);
	
//	List<Students> getAllByName(String name); //without using HQL query
	
	@Query("From Students where name=:name")
	List<Students> getAllByName(String name);
	
	
	@Query("From Students where age=:age")
	List<Students> getStudentByAge(int age);
	
	
	@Query("From Students where age>:age")
	List<Students> getAllGreaterAge(int age);

	@Query("From Students where age<:age")
	List<Students> getAllLesserAge(int age);
	
	@Query("From Students where name=:name and age=:age")
	List<Students> getByNameAndAge(String name, int age);
	
	
	
	@Query("from Students where age=:age")
	public List<Students> getByAge(int age);
	
	
	//To perform any DML operation
	@Query("delete from Students where id=:id")
	@Modifying
	@Transactional
	void deletebyid(int id);
	
	
//	Same thing you have to perform the update operation updatebyid or name or age task...
	
	@Query("Update Students set name=:name where id=:id")
	@Modifying
	@Transactional
	void updateNamebyIdd(String name, int id);
	
	
	@Query("Update Students set age=:age where name=:name")
	@Modifying
	@Transactional
	void updateAgebyNamee(int age, String name);
	
	
	@Query("Update Students set name=:name where age=:age")
	@Modifying
	@Transactional
	void updateNamebyAge(String name, int age);
//	-------------------------------
	@Query("DELETE FROM Students WHERE pk = :pk")
    @Modifying
    @Transactional
    void deleteByPkId(StudentsPk pk);
	
	@Query("UPDATE Students s SET s.name = :name WHERE s.pk.id = :id")
    @Modifying
    @Transactional
    void updateNameById(String name, StudentsPk pk);

    @Query("UPDATE Students s SET s.age = :age WHERE s.name = :name")
    @Modifying
    @Transactional
    void updateAgeByName(int age, String name);

	Optional<Students> findById(StudentsPk pk);

}