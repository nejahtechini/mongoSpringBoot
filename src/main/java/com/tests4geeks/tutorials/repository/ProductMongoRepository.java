package com.tests4geeks.tutorials.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tests4geeks.tutorials.model.Product;
import com.tests4geeks.tutorials.model.User;


	public interface ProductMongoRepository extends CrudRepository<Product, String>{
		
		

	

}
