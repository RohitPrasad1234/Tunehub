package com.example.demo.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entitys.users;

public interface StudentRepo extends JpaRepository<users, Integer>{
    public users findByEmail (String email);
}
