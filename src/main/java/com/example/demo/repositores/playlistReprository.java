package com.example.demo.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entitys.playlist;

public interface playlistReprository extends JpaRepository<playlist, Integer>{

}
