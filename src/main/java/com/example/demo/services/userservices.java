package com.example.demo.services;

import com.example.demo.entitys.users;

public interface userservices {
	public String create(users u);

	public boolean checkemail(String email);

	public boolean validate(String email, String password);

	public String getRole(String email);

	public users getemail(String email);

	void updateuser(users u);

	public users getUser(String email);

}
