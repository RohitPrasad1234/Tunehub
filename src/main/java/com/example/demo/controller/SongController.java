package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.entitys.newsong;
import com.example.demo.services.songservice;

@Controller
public class SongController {
	@Autowired
	songservice as;
	@PostMapping("/addsong")
	public String addnewsong(@ModelAttribute newsong s) {
		boolean validate=as.findsong(s.getName());
		if(validate==false) {
			as.addsong(s);
			System.out.println("song added");
			return "adminhome";
			
		}else {
			System.out.println("song already present");
			return "addsong";
		}
			
		
	}
	@GetMapping("/viewsongs")
	public String viewsongs(Model model) {
		List<newsong> listallsong=as.findallsongs();
		model.addAttribute("songs",listallsong);
		return "viewsongs";
	}
	
		
	@GetMapping("/playsongs")
	public String playsongs(Model model) {
		boolean checkpremium=false;
		if(checkpremium==true) {
			List<newsong> listallsong=as.findallsongs();
			model.addAttribute("songs",listallsong);
			return "viewsongs";
		}
		else {
			return "makepayment";
		}
		
	}
}
