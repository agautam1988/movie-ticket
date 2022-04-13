package com.sapient.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.sapient.demo.entity.User;  

public interface UserRepo extends CrudRepository<User, Long>{

}
