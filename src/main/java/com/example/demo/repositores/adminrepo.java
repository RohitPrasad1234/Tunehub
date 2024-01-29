package com.example.demo.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entitys.newsong;
import com.example.demo.entitys.users;

public interface adminrepo extends JpaRepository<newsong, Integer> {

	public newsong findByName(String name);


}
