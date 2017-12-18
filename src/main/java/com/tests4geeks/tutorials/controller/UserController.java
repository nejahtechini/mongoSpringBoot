package com.tests4geeks.tutorials.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.tests4geeks.tutorials.model.Product;
import com.tests4geeks.tutorials.model.User;
import com.tests4geeks.tutorials.repository.ProductMongoRepository;
import com.tests4geeks.tutorials.repository.UserMongoRepository;
import com.tests4geeks.tutorials.service.UserServiceImpl;

@CrossOrigin
@RestController
@RequestMapping(value = "/rest/users")

public class UserController {
	
	@Autowired
	GridFsOperations gridOperations;
	
	// this variable is used to store ImageId for other actions like: findOne or delete
	private String imageFileId = "";
	@Autowired
	UserMongoRepository userRepository;
	@Autowired
	ProductMongoRepository productRepository;
	
	@Autowired
	UserServiceImpl userService;

	@RequestMapping(value = "/allUser", method = RequestMethod.GET)
	public List<User> getAllUser() {
		List<User> listUser = userService.getAllUser();

		return listUser;
	}

	@RequestMapping(value = "/load", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public User persist(@RequestBody final User user) {

		return userService.persist(user);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public Boolean deleteUser(@PathVariable Integer id) {

		userService.deleteUser(id);
		return true;
	}

	@RequestMapping(value = "name/{name}", method = RequestMethod.GET)
	public User getUserByName(@PathVariable("name") String name) {
		User user = userService.getUserByName(name);

		return user;
	}

	@RequestMapping(value ="/save", method = RequestMethod.POST)
	public String saveFiles() throws FileNotFoundException {
		// Define metaData
		DBObject metaData = new BasicDBObject();
		metaData.put("organization", "JavaSampleApproach");
		
		/**
		 * 1. save an image file to MongoDB
		 */
		
		// Get input file
Product product = new Product();
//		
		
		InputStream iamgeStream = new FileInputStream("C:\\Users\\marwa\\Desktop\\Downloads\\im.jpg");
		
		metaData.put("type", "image");
		
		// Store file to MongoDB
//	product.setImage(gridOperations.store(iamgeStream, "jsa-logo.png", "image/png", metaData).getId());
//		System.out.println("ImageFileId = " + imageFileId);

		/**
		 * 2. save text files to MongoDB
		 */
//	productRepository.save(product) ;
//		// change metaData
//		metaData.put("type", "data");
//
//		// Store files to MongoDb
//		gridOperations.store(new FileInputStream("D:\\JSA\\text-1.txt"), "text-1.txt", "text/plain", metaData);
//		gridOperations.store(new FileInputStream("D:\\JSA\\text-2.txt"), "text-2.txt", "text/plain", metaData);

		return "Done";
	}
	
}
