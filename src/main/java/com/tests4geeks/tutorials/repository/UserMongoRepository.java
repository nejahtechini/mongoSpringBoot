package com.tests4geeks.tutorials.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tests4geeks.tutorials.model.User;

public interface UserMongoRepository extends CrudRepository<User, String> {
	List<User> findAll();

	long count();

	User findById(Integer id);

	User findByName(String name);
}