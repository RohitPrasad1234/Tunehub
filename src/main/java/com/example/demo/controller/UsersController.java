package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entitys.newsong;
import com.example.demo.entitys.users;
import com.example.demo.services.songservice;
import com.example.demo.services.userservices;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UsersController {
	@Autowired
	userservices s;
	
	@Autowired
	songservice as;
	
	@PostMapping("/register")
        public String maping(@ModelAttribute users user) {
		boolean userStatus=s.checkemail(user.getEmail());
		if(userStatus==false) {
			s.create(user);
			String role=s.getRole(user.getEmail());
    		if(role.equals("admin")) {
    			return "adminhome";
    		}
    		else {
    			return "customerhome";
    		}
		}
		else {
			System.out.println("user is already existed");
			return "login";
		}
    	
	
        }
	@PostMapping("/login")
    public String login(@RequestParam String email,@RequestParam String password,
    		
    		HttpSession session,Model model) {
    	boolean checklogin=s.validate(email,password);
    	if(checklogin==true) {
    		String role=s.getRole(email);
    		session.setAttribute("email", email);
    		if(role.equals("admin")) {
    			return "adminhome";
    		}
    		else {
    		    users user=s.getUser(email);
    		    boolean b=user.isPremium();
    		    model.addAttribute("premium", b);
    		    List<newsong> listallsong=as.findallsongs();
    			model.addAttribute("songs",listallsong);
    			return "customerhome";
    		}
    		
    	}
    	else {
    		return "login";
    	}
    }
	
    
   @GetMapping("/logout")
   public String logout(HttpSession session) {
	   session.invalidate();
	   return "login";
   }
	
}
