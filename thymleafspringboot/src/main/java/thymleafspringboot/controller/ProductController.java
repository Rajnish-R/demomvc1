package thymleafspringboot.controller;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import thymleafspringboot.binding.Product;
import thymleafspringboot.entity.ProductEntity;
import thymleafspringboot.repository.ProductRepository;


@Controller
@RequestMapping("/shopping")
public class ProductController {
	
	@Autowired
	private ProductRepository repository;
	
	@GetMapping("/welcome")
	public String welcomeHome(Model model) {
		model.addAttribute("product", new Product());
		return "index";
	}

	@PostMapping("/registerProduct")
	public String add(Product p,Model model) {
		ProductEntity e=new ProductEntity();
		BeanUtils.copyProperties(p, e);
		repository.save(e);
		model.addAttribute("msg", "Product registered successfully!");
		model.addAttribute("product", new Product());
		return "index";
	}
	
	
}