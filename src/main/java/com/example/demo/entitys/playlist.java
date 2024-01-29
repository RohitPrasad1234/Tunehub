package com.example.demo.entitys;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class playlist {
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 int id;
 String name;
 
 @ManyToMany
 List<newsong> songs;

public playlist() {
	super();

}

public playlist(int id, String name, List<newsong> songs) {
	super();
	this.id = id;
	this.name = name;
	this.songs = songs;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public List<newsong> getSongs() {
	return songs;
}

public void setSongs(List<newsong> songs) {
	this.songs = songs;
}

@Override
public String toString() {
	return "playlist [id=" + id + ", name=" + name + ", songs=" + songs + "]";
}


}
