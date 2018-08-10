package com.example.dataservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.dataservice.entity.User;

public interface UserRepository extends CrudRepository<User, Long>  {
	
	User findUserByUserName(String userName);

}
