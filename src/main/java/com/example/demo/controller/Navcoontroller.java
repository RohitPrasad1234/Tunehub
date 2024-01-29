package com.example.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;




@Controller
public class Navcoontroller {

	 @GetMapping("/login")
	 public String Login() {
		 return "login";
	 }
	 
	@GetMapping("/registration")
	 public String registration()
	 {
		 return "register";
	 }
	
	@GetMapping("/addsong")
	public String addsong() {
		return "addsong";
	}
}
