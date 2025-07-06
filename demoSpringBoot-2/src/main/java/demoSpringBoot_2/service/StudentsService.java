package demoSpringBoot_2.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import demoSpringBoot_2.entity.Students;
import demoSpringBoot_2.entity.StudentsPk;
import demoSpringBoot_2.repository.StudentsRepository;


@org.springframework.stereotype.Service
public class StudentsService implements Service {
	
	@Autowired
	private StudentsRepository repository;
	
	@Override
	public Students saveStudent(Students students)
	{
		return repository.save(students);
		// Create & Update
	}
	
	@Override
	public List<Students> getAllStudents()
	{
		return repository.findAll();
		// Read
	}

	
	@Override
    public void deleteStudentByPk(StudentsPk pk) {
        repository.deleteByPkId(pk); // Delete
    }

	@Override
	public Students updateStudentName(StudentsPk pk, String name) {
	    Optional<Students> studentOptional = repository.findById(pk);
	    if (studentOptional.isPresent()) {
	        Students student = studentOptional.get();
	        student.setName(name);
	        return repository.save(student); // Update & Save
	    }
	    return null;
	}
	
	@Override
	public Students updateStudentAge(StudentsPk pk, int age) {
	    Optional<Students> studentOptiona = repository.findById(pk);
	    if (studentOptiona.isPresent()) {
	        Students stud = studentOptiona.get();
	        stud.setAge(age);
	        return repository.save(stud); // Update & Save
	    }
	    return null;
	}
}