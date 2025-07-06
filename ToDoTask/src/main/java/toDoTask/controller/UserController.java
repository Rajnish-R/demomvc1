package toDoTask.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import toDoTask.binding.User;
import toDoTask.entity.UserEntity;
import toDoTask.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/register")
	public String showRegisterPage(Model model) {
	    model.addAttribute("user", new User());
	    return "register";
	}
	
	@PostMapping("/saveUser")
	public String userSave(User user, Model model) {
	    try {
	        UserEntity userEntity = new UserEntity();
	        BeanUtils.copyProperties(user, userEntity);
	        userRepository.save(userEntity);
//	        return "redirect:/login"; // redirect to login page after successful registration
	        return "redirect:/user/login"; // matches the new GetMapping
	    } catch (Exception e) {
	        model.addAttribute("error", "Registration failed: " + e.getMessage());
	        model.addAttribute("user", new User());
	        return "register";
	    }
	}
	
	@GetMapping("/login")
	public String showLoginPage(Model model) {
	    model.addAttribute("login", new User());
	    return "login"; // <- this is your Thymeleaf login.html view
	}
	
	@PostMapping("/doLogin")
	public String doLogin(User loginForm, Model model, HttpSession session) {
	    UserEntity user = userRepository.findById(loginForm.getEmail()).orElse(null);
	    if (user != null && user.getPassword().equals(loginForm.getPassword())) {
	    	session.setAttribute("loggedInUser", user);
	        return "redirect:/task/home"; // or wherever the user lands post-login
	    } else {
	        model.addAttribute("error", "Invalid email or password");
	        return "login";
	    }
	}
	
	@GetMapping("/details")
	public String userDetails(Model model, HttpSession session) {
	    UserEntity user = (UserEntity) session.getAttribute("loggedInUser");
	    model.addAttribute("user", user);
	    return "userDetails"; // create this .html page
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
	    session.invalidate();
	    return "redirect:/user/login";
	}
}


//	@PostMapping("/saveUser")
//	public String userSave(Model model, User user)
//	{
//		System.out.println("save triggered");
//		
//		UserEntity userEntity = new UserEntity();
//		BeanUtils.copyProperties(user, userEntity);
//		userRepository.save(userEntity);
//		model.addAttribute("user", new User());
//		return "register";
//	}

