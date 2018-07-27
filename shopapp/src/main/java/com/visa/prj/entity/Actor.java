package com.visa.prj.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Actor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // can't be given for a string, only works for integers == AUTO-INCREMENT
	private int id;
	
	private String name;
	
	@ManyToMany(mappedBy="actors")
	private List<Movie> movies = new ArrayList<>();

	@Override
	public String toString() {
		return "Actor [id=" + id + ", name=" + name + ", movies=" + movies + "]";
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

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
}
