package demoSpringBoot_2.service;

import java.util.List;

import demoSpringBoot_2.entity.Students;
import demoSpringBoot_2.entity.StudentsPk;

public interface Service {
	// Create & Update
	Students saveStudent(Students students);
    
    //Read
    List<Students> getAllStudents();
 
    //Delete
    void deleteStudentByPk(StudentsPk pk);
    
    //Update Name
    Students updateStudentName(StudentsPk pk, String name);
    
    //Update Age
    Students updateStudentAge(StudentsPk pk, int age);
}