package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entitys.users;
import com.example.demo.repositores.StudentRepo;
@Service
public class userserviceimplimentation implements userservices {
   @Autowired
	StudentRepo sr;
	

	@Override
	public String create(users u) {
		sr.save(u);
		return "created account";
	}


	@Override
	public boolean checkemail(String email) {
		// TODO Auto-generated method stub
		if(sr.findByEmail(email)==null) {
			return false;
		}
		else {
			return true;
		}
	}


	@Override
	public boolean validate(String email, String password) {
		// TODO Auto-generated method stub
		users user=sr.findByEmail(email);
	     if(password.equals(user.getPassword())) {
	    	 return true; 
	     }
	     else {
	    	 return false;
	     }
	}


	@Override
	public String getRole(String email) {
		// TODO Auto-generated method stub
	    users u=sr.findByEmail(email);
		String role=u.getRole();
		return role;
	}


	@Override
	public users getemail(String email) {
		// TODO Auto-generated method stub
		return sr.findByEmail(email);
	}


	@Override
	public void updateuser(users u) {
		// TODO Auto-generated method stub
		sr.save(u);
	}

	@Override
	public users getUser(String email) {
		// TODO Auto-generated method stub
		
		 return sr.findByEmail(email);
		
	}


	
}
