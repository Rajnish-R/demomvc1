package demomvc.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import demomvc.entity.Student;
import demomvc.repository.StudentRepository;



@Controller

public class HomeController {

	@Autowired
	StudentRepository studentRepository;
	
	@GetMapping("/welcome")
	public String welcomeHome()
	{
		return "index";
	}
	
	@GetMapping("/home")
	public ModelAndView greetings(ModelAndView modelAndView) {
		modelAndView.addObject("msg", "welcome to home page");
		modelAndView.setViewName("home");
		return modelAndView;
	}
	
	@PostMapping("/submit")
	public ModelAndView save(Student student, ModelAndView modelAndView)
	{
		modelAndView.addObject("student", student);
		modelAndView.setViewName("profile");
		studentRepository.save(student);
		return modelAndView;
	}
	
	@GetMapping("/getbyname")
	public ModelAndView fetchbyname(@RequestParam String name, ModelAndView modelAndView)
	{
		modelAndView.addObject("name", name);  //http://localhost:8080/getbyname?name=Rajnish%20Raj
		List<Student> sts = studentRepository.findByName(name);
		modelAndView.setViewName("profile");
		return modelAndView;
	}
	
	@GetMapping("/getByAge/{age}")
	public ModelAndView fetchbyage(@PathVariable int age, ModelAndView modelAndView)
	{
		modelAndView.addObject("age", age);
		List<Student> stu = studentRepository.findByAge(age);
		modelAndView.setViewName("profile");
		return modelAndView;
	}
	
	@GetMapping("/getbyages/{age}")
	public String fetchbyage(@PathVariable int age, Model model)
	{
		model.addAttribute("age", age);
		List<Student> sts = studentRepository.findByAge(age);
		return "profile";
	}
}

//If there is no required for the security then we can use the RequsetParam or PathVariable RequstBody