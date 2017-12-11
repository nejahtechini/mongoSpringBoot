package com.tests4geeks.tutorials.repository;

import org.springframework.data.repository.CrudRepository;

import com.tests4geeks.tutorials.model.UserEmail;

public interface UserEmailMongoRepository  extends CrudRepository<UserEmail, Integer> {

}
