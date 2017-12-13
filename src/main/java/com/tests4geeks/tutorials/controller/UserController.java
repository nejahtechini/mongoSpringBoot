package com.tests4geeks.tutorials.controller;

import java.util.List;

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
import com.tests4geeks.tutorials.service.UserServiceImpl;

@CrossOrigin
@RestController
@RequestMapping(value = "/rest/users")

public class UserController {
	
	
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


	
}
