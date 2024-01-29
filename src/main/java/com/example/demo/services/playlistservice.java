package com.example.demo.services;

import java.util.List;

import com.example.demo.entitys.playlist;

public interface playlistservice {

	public void addplaylist(playlist pl);

	public List<playlist> fetchallplaylist();

}
