package com.example.demo.services;

import java.util.List;

import com.example.demo.entitys.newsong;

public interface songservice {
   public String addsong(newsong ns);
   
public List<newsong> findallsongs();

public boolean findsong(String name);

public void updatesong(newsong s);



 
  
}
