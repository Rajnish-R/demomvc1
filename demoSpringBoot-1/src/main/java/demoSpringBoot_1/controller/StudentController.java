package demoSpringBoot_1.controller;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import demoSpringBoot_1.Entity.Student;
import demoSpringBoot_1.Repository.StudentRepository;

//For postman application use we are using this annotation @RestController
//@RestController //it returns the data
//public class StudentController {
//	
//	@GetMapping("/save")
//	public String save()
//	{
//		System.out.println("Triggered");
//		return "hello";
//	}
//}


//@Controller //it will not return the data so that we have to use the @ResponseBody else browser will throw error
//public class StudentController {
//	
//	@GetMapping("/save")
//	@ResponseBody
//	public String save()
//	{
//		System.out.println("Triggered");
//		return "hello";
//	}
//}

//@RestController
//@RequestMapping("/api/student")
//public class StudentController {
//	
//	@PostMapping("/save")
//	public String save()
//	{
//		System.out.println("Triggered");
//		return "hello";
//	}
//}
//localhost:8080/api/student/save



//CRUD OPERATIONS THROUGH API
//@RestController
//@RequestMapping("/api/student")
//public class StudentController {
//	
//	@Autowired
//	private StudentRepository studentRepository;
//	
//	@PostMapping("/save")
//	public String save(@RequestBody Student student)
//	{
//		studentRepository.save(student);
//		return "data saved!";
//	}
//}
/*By using we are storing the data into database but in postman we have do like this
{
    "id": 103,
    "name": "Rajnish Raj",
    "age": 24
}
localhost:8080/api/student/save
*/


@RestController
@RequestMapping("/api/student")
public class StudentController {
	
	//Create/insert
	@Autowired
	private StudentRepository repository;
	
	@PostMapping("/save")
	public String save(@RequestBody Student student)
	{
		repository.save(student);
		return "data saved!";
	}
	
	//Select/fetch
	@GetMapping("/get-Allstudent")
	public List<Student> getAllStudent(){
		return repository.findAll();
	}
	
//	Exception handling example
	
	
//	@GetMapping("/get-student")
//	public ResponseEntity<Student> getStudent() {
//	    Optional<Student> opt = repository.findById(105);
//	    
//	    return opt.map(ResponseEntity::ok)
//	              .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
//	}
	
	//Update
//	@PutMapping("/update")
//	public String update(@RequestBody Student stu)
//	{
//		int id = stu.getId();
//		Optional<Student> optional = repository.findById(id);
//		Student st = optional.get();
//		repository.save(stu);
//		return "data saved!";
//	}
	
/*
{localhost:8080/api/student/update
    "id": "105",
    "name": "Praveen Hegde",
    "age": "30"
}
*/

	//Delete/Remove
//	@DeleteMapping("/delete/{id}")
//	public String delete(@PathVariable int id)
//	{
//		boolean flag = repository.existsById(id);
//		if(flag)
//		{
//		        repository.deleteById(id); // Actually deletes the student
//		        return "Student deleted!";
//		}
//		else
//		{
//			return "id no found";
//		}
//	}
	//localhost:8080/api/student/delete/105
	
	
//	@DeleteMapping("/todelete")
//	public String todelete(@RequestParam int id)
//	{
//		boolean flag = repository.existsById(id);
//		if(flag)
//		{
//			repository.deleteById(id);
//			return "student deleted";
//		}
//		else
//		{
//			return "id not found";
//		}
//	}  //http://localhost:8080/api/student/todelete?id=105
	
	@GetMapping("/getall")
	public List<Student> getAll()
	{
		List<Student> list = repository.findAll();
		return list;
	} //localhost:8080/api/student/getall
	
	
	
//	@GetMapping("/getbyage/{age}")
//	public List<Student> getByAge(@PathVariable int age)
//	{
//		return repository.getAllByAge(age);
//	}//http://localhost:8080/api/student/getbyage/24
	
	
//	@GetMapping("/getbyname")
//	public List<Student> getAllByName(@RequestParam String name)
//	{
//		return repository.getAllByName(name);
//	}//http://localhost:8080/api/student/getbyname?name=Rajnish
	
	
	@GetMapping("/getbyname/{name}")
	public List<Student> getAllByName(@PathVariable String name)
	{
		return repository.getAllByName(name);
	}	//http://localhost:8080/api/student/getbyname/Rajnish
	
	
//	@GetMapping("/getStudentById/{id}")
//	public Student getStudentById(@PathVariable int id)
//	{
//		return repository.findById(id).get();
//	} //http://localhost:8080/api/student/getStudentById/103
	
//	------------------------------------------------
	
	@GetMapping("/getstudentByAge/{age}")
	public List<Student> getStudentByAge(@PathVariable int age)
	{
		return repository.getStudentByAge(age);
	}//http://localhost:8080/api/student/getstudentByAge/24
	
	
	@GetMapping("/age-greater-than/{age}")
	public List<Student> getAllGreaterAge(@PathVariable int age)
	{
		return repository.getAllGreaterAge(age);
	}//http://localhost:8080/api/student/getstudentByAge/24
	
	
	@GetMapping("/age-lesser-than/{age}")
	public List<Student> getAllLesserAge(@PathVariable int age)
	{
		return repository.getAllLesserAge(age);
	} //http://localhost:8080/api/student/age-lesser-than/26
	
	@GetMapping("/get-name-and-age/{name}/{age}")
	public List<Student> getAllByNameAndAge(@PathVariable String name, @PathVariable int age)
	{
		return repository.getByNameAndAge(name, age);
	}	//http://localhost:8080/api/student/get-name-and-age/Rajnish Raj/24
	
	
//	Pagination Concept
	
	@GetMapping("/getAlls")
	public List<Student> getAlls()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the page no");
		int pageno = sc.nextInt();
		
		int pagesize = 4;
		
		PageRequest pageRequest = PageRequest.of(pageno-1, pagesize);
		Page<Student> findall = repository.findAll(pageRequest);
		
		List<Student> content = findall.getContent();
		return content;
	}
	
	//Sorting methods 
	
	@GetMapping("/GetByAll")
	public List<Student> GetAlls()
	{
		return repository.findAll(Sort.by("age"));
	}
	
	
	@GetMapping("/getbyage/{age}")
	public List<Student> getByAge(@PathVariable int age)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the pageno");
		int pagen = s.nextInt();
		
		int pagesizes = 3;
		PageRequest pageRequest = PageRequest.of(pagen-1, pagesizes);
			Page<Student> findALL = repository.findAll(pageRequest);
			List<Student> contnt = findALL.getContent();
		return contnt;
	}
	
	// QueryBy Concept Example of Filter options in naukri.com or shopping app filter conditions etc
	@GetMapping("/Getalls")
	public List<Student> getalls(@RequestParam Integer age, @RequestParam String name) {
		Student st = new Student();
		st.setAge(age);  
		st.setName(name);
	    Example<Student> ex = Example.of(st);
	    List<Student> all = repository.findAll(ex);
	    for(Student student : all)
	    {
	    	System.out.println(student.getAge() + " " + student.getName());
	    }
	    return repository.findAll(ex);
	}
	
//	Hard deleting soft deleting
	

	
	@DeleteMapping("/deleteById")
	public String deleteById(@RequestParam int id)
	{
		repository.deletebyid(id);
		return "deleted";
	}
	
	@PutMapping("/updateNameByIdd")
	public String updateByIdd(@RequestParam String name, @RequestParam int id)
	{
		repository.updateNamebyIdd(name, id);
		return "data updated";
	}//http://localhost:8080/api/student/updateNameByIdd?name=Rajnish&id=103
	
	
	@PutMapping("/updateAgeByName")
	public String updateAgeByNamee(@RequestParam int age, @RequestParam String name)
	{
		repository.updateAgebyNamee(age, name);
		return "age updated by name";
	}
	
	@PutMapping("/updateNameByAge")
	public String updateNamebyAge(@RequestParam String name, @RequestParam int age)
	{
		repository.updateNamebyAge(name, age);
		return "name updated by age";	}
}
		


//@Controller
//@RequestMapping("/api")
//public class StudentController {
//	
//	@GetMapping("/home")
//	@ResponseBody
//	public String home()
//	{
//		return "hello home!";
//	}
//}