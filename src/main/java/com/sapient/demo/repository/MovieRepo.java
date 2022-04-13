package com.sapient.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.sapient.demo.entity.Movie;

public interface MovieRepo extends CrudRepository<Movie, Long>{
	public Movie findByName(String name);
}


