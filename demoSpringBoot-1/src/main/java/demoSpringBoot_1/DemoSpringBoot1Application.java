package demoSpringBoot_1;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import demoSpringBoot_1.Entity.Student;
import demoSpringBoot_1.Repository.StudentRepository;

@SpringBootApplication
public class DemoSpringBoot1Application {

	public static void main(String[] args) {
	ConfigurableApplicationContext context	= SpringApplication.run(DemoSpringBoot1Application.class, args);

	System.out.println(context.getClass().getName());

	StudentRepository repository  = context.getBean(StudentRepository.class);

	//Create/Insert
//	Student std1 = new Student();
//	std1.setId(102);
//	std1.setName("Aman Kumar");
//	std1.setAge(24);
//	repository.save(std1);
//	System.out.println("Data saved in the database.");
//
	//Read/Retrieve
//	List<Student> list = repository.findAll();
//	for(Student student: list)
//	{
//		System.out.println(student.getId() + " " + student.getName() + " " + student.getAge());
//	}

//	 Optional<Student> optional = repository.findById(101);
//	 if(optional.get() != null)
//	 {
//		 System.out.println(optional.get().getName());

		 //Update/Modify
//		 Student stu = optional.get();
//		 stu.setAge(22);
//		 repository.save(stu);
//		 System.out.println("Data updated");
	// }
	 //Delete
//	 repository.deleteById(102);

	}
}
//CRUD Operation