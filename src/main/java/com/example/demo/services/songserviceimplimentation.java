package com.example.demo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entitys.newsong;
import com.example.demo.repositores.adminrepo;

@Service
public class songserviceimplimentation implements songservice {

    @Autowired
    adminrepo ar;

    @Override
    public String addsong(newsong ns) {
        ar.save(ns);
        return "adminhome"; 
    }

	@Override
	public List<newsong> findallsongs() {
		// TODO Auto-generated method stub
		return ar.findAll();
	}

	@Override
	public boolean findsong(String name) {
		// TODO Auto-generated method stub
		newsong valid=ar.findByName(name);
		if(valid == null) {
			return false;
		}
		else {
			return true;
		}
		
	}

	@Override
	public void updatesong(newsong s) {
		// TODO Auto-generated method stub
		ar.save(s);
	}

	

   
}
