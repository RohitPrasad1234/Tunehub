package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entitys.playlist;
import com.example.demo.repositores.playlistReprository;

@Service
public class playlistserviceimplement 
	implements playlistservice{
	@Autowired
   playlistReprository pr;
	@Override
	public void addplaylist(playlist pl) {
		// TODO Auto-generated method stub
	pr.save(pl);
		
	}
	@Override
	public List<playlist> fetchallplaylist() {
		// TODO Auto-generated method stub
		return pr.findAll();
	}
	
       
}
