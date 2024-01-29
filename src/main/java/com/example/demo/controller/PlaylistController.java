package com.example.demo.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entitys.newsong;
import com.example.demo.entitys.playlist;
import com.example.demo.services.playlistservice;
import com.example.demo.services.songservice;

@Controller
public class PlaylistController {
	@Autowired
    songservice ss;
	
	@Autowired
	playlistservice ps;
	
	 @GetMapping("/createplaylist")
	 public String createplaylist(Model model) {
		 List<newsong> listallsong=ss.findallsongs();
			model.addAttribute("songs",listallsong);
			return "createplaylist";
	 }
	 
	 @PostMapping("/addplaylist")
	 public String addplaylist(@ModelAttribute playlist playlist) {
		ps.addplaylist(playlist);
		List<newsong> song=playlist.getSongs();
		for(newsong s: song) {
			s.getPlaylists().add(playlist);
			ss.updatesong(s);
		}
		return "adminhome";
		 
	 }
	 @GetMapping("/viewPlaylist")
	 public String viewPlaylist(Model model) {
		 List<playlist> viewplaylist=ps.fetchallplaylist();
		 model.addAttribute("viewplaylist",viewplaylist);
		 return "displayplaylist";
	 }
	 
}
