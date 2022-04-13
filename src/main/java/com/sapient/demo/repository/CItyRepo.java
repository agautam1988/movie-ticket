package com.sapient.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.sapient.demo.entity.City;

public interface CItyRepo extends CrudRepository<City, Long>{
  public City findByName(String name );
}
