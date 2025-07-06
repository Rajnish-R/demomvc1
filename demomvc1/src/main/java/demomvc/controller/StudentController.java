package demomvc.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import demomvc.binding.Students;
import demomvc.entity.StudentEntity;
import demomvc.repository.StudentEntityRepository;


@Controller
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentEntityRepository seRepository;
	
	@GetMapping("/register")
	public String loadForm(Model model) {
		System.out.println("helo");
		loadFormData(model);
		return "indexes";
	}


	private void loadFormData(Model model)
	{
		List<String> courses = new ArrayList();
		courses.add("Java Full Stack Developer");
		courses.add("Python Full Stack Developer");
		courses.add("MERN Stack Developer");
		courses.add("MEAN Stack Developer");
		courses.add("AWS");
		courses.add("Devops");
		
		List<String> timings = new ArrayList();
		timings.add("Monday");
		timings.add("Tuesday");
		timings.add("Wednesday");
		timings.add("Thursday");
		timings.add("Friday");
		
		Students students = new Students();
		model.addAttribute("courses", courses);
		model.addAttribute("timings", timings);
		model.addAttribute("students", students);
	}
	
	@PostMapping("/submit")
	public String saveStudent(Students s, Model model) {
		loadFormData(model);
		StudentEntity entity = new StudentEntity();
		BeanUtils.copyProperties(s, entity);
		entity.setTimings(Arrays.toString(s.getTimings()));
		seRepository.save(entity);
		System.out.println("Yes, I am triggered");
		model.addAttribute("msg", "Data saved");
		return "indexes";
	}
}