package com.tests4geeks.tutorials.repository;

import org.springframework.data.repository.CrudRepository;

import com.tests4geeks.tutorials.model.UserAddress;

public interface UserAddressMongoRepository extends CrudRepository<UserAddress, String> {

}
