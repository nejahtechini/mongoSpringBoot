package com.tests4geeks.tutorials.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tests4geeks.tutorials.model.User;
import com.tests4geeks.tutorials.repository.EmailMongoRepository;
import com.tests4geeks.tutorials.repository.UserAddressMongoRepository;
import com.tests4geeks.tutorials.repository.UserMongoRepository;

@CrossOrigin
@RestController
@RequestMapping(value = "/rest/users")

public class UserController {

	@Autowired
	UserMongoRepository userRepository;
	@Autowired
	EmailMongoRepository emailRepository;
	@Autowired
	UserAddressMongoRepository userAddressRepository;
	@RequestMapping(value = "/allUser", method = RequestMethod.GET)
	public List<User> getAllUser() {
		List<User> listUser = userRepository.findAll();
		
		return listUser;
	}

	@RequestMapping(value = "/load", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public User persist(@Valid @RequestBody final User user) {
		if (user.getId() == null) {
			Integer userNumber = (int) userRepository.count();
			user.setId(userNumber + 1);
		}
		return userRepository.save(user);
	}

	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	public Boolean deleteUser(@PathVariable Integer id) {
		User user = userRepository.findById(id);
     emailRepository.delete(user.getUserEmail());
	     userAddressRepository.delete(user.getUserAddress());
		userRepository.delete(user);
		return true;
	}

	@RequestMapping(value = "name/{name}", method = RequestMethod.GET)
	public User getUserByName(@PathVariable("name") String name) {
		User user = userRepository.findByName(name);

		return user;
	}

}
