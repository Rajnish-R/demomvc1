package demoSpringBoot_2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import demoSpringBoot_2.entity.Students;
import demoSpringBoot_2.entity.StudentsPk;
import demoSpringBoot_2.exception.StudentException;
import demoSpringBoot_2.service.StudentsService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

	// ------------Composite key example-------
		@Autowired
	    private StudentsService studentService;

	    @PostMapping("/save")
	    public String saveStudent(@RequestBody Students student) {
	        return studentService.saveStudent(student) != null ? "Student saved successfully" : "Failed to save student";
	    }
	    
	  //Exception handling example
		
		@PostMapping("/saved")  //localhost:8080/api/students/saved
		public String saved(@RequestBody Students student)
		{
			student.setName(null);
			String name = student.getName();
			System.out.println(name.length());
			Students st = studentService.saveStudent(student);
			if(st != null)
			{
				return "saved";
			}
			else
			{
				return "data not saved";
			}
		}
		
		@PostMapping("/arithmetic") //localhost:8080/api/students/arithmetic
		public String arithmeticExceptionsave()
		{
			int result = 2/0;
			return "Result" +result;
		}
		
		@PostMapping("/triggerException")  //localhost:8080/api/students/triggerException
		public String triggerGeneralException() throws Exception {
		    throw new Exception("General exception triggered!");
		}
		
		
		@PostMapping("/triggercustomeException")  //localhost:8080/api/students/triggercustomeException
		public String triggerCustomeException()
		{
			throw new StudentException("Custome Student Exception Triggered!!");
		}
		//cretate coustome exception and handle the exception of all the related exceptions

	    @GetMapping("/getall")
	    public List<Students> getAllStudents() {
	        return studentService.getAllStudents();
	    }

	    @DeleteMapping("/delete")
	    public String deleteStudent(@RequestBody StudentsPk pk) {
	        studentService.deleteStudentByPk(pk);
	        return "Student deleted successfully";
	    }

	    @PutMapping("/updateName")
	    public String updateStudentName(@RequestBody StudentsPk pk, @RequestParam String name) {
	        return studentService.updateStudentName(pk, name) != null ? "Student name updated successfully" : "Student not found";
	    }

	    @PutMapping("/updateAge")
	    public String updateStudentAge(@RequestBody StudentsPk pk, @RequestParam int age) {
	        return studentService.updateStudentAge(pk, age) != null ? "Student age updated successfully" : "Student not found";
	    }

//		    @Autowired
//		    private Service studentService;
//
//		    // Create or Update a Student
//		    @PostMapping("/save")
//		    public String saveStudent(@RequestBody Student student) {
//		        return studentService.saveStudent(student) != null ? "Data saved successfully" : "Data not saved";
//		    }
//	
//		    // Read - Get all Students
//		    @GetMapping("/getall")
//		    public List<Student> getAllStudents() {
//		        return studentService.getAllStudents();
//		    }
//	
//		    // Delete a Student by ID
//		    @DeleteMapping("/delete/{id}")
//		    public String deleteStudent(@PathVariable StudentPk pk) {
//		        studentService.deleteStudentByPk(pk);
//		        return "Student deleted successfully";
//		    }
//	
//		    // Update a Student's Name
//		    @PutMapping("/updateName/{id}")
//		    public String updateStudentName(@PathVariable StudentPk pk, @RequestParam String name) {
//		        return studentService.updateStudentName(pk, name) != null ? "Student name updated successfully" : "Student not found";
//		    }
//	
//		    // Update a Student's Age
//		    @PutMapping("/updateAge/{id}")
//		    public String updateStudentAge(@PathVariable StudentPk pk, @RequestParam int age) {
//		        return studentService.updateStudentAge(pk, age) != null ? "Student age updated successfully" : "Student not found";
//		    }
}
