package com.tests4geeks.tutorials.repository;

import org.springframework.data.repository.CrudRepository;

import com.tests4geeks.tutorials.model.Email;
import com.tests4geeks.tutorials.model.User;

public interface EmailMongoRepository extends CrudRepository<Email, String> {


	long count();

	User findById(Integer id);

	
}


