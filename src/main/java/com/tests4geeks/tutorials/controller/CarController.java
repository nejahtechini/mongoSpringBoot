package com.tests4geeks.tutorials.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tests4geeks.tutorials.model.User;
import com.tests4geeks.tutorials.repository.CarMongoRepository;



@CrossOrigin
@RestController
@RequestMapping(value = "/rest/users")

public class CarController {

	@Autowired
	CarMongoRepository carRepository;
	

	
	@RequestMapping(value = "/allUser" , method = RequestMethod.GET)
	public List<User> getAllUser() {
		List<User>listUser=carRepository.findAll();
		
		return listUser;
	}
	
	 
		@RequestMapping(value = "/load", method = RequestMethod.POST)
		 @ResponseStatus(HttpStatus.CREATED)
		public User persist(@Valid @RequestBody final User user)  {
			
			 	return carRepository.save(user);
			  	}
		

	
	 
//	    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
//	    User delete(@PathVariable("id") String id) {
//	        return carRepository.delete(id)  ;
//	    }

//	 
//	    @RequestMapping(method = RequestMethod.GET)
//	    List<TodoDTO> findAll() {
//	        return service.findAll();
//	    }
//	 
//	    @RequestMapping(value = "{id}", method = RequestMethod.GET)
//	    TodoDTO findById(@PathVariable("id") String id) {
//	        return service.findById(id);
//	    }
//	 
//	    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
//	    TodoDTO update(@RequestBody @Valid TodoDTO todoEntry) {
//	        return service.update(todoEntry);
//	    }
	 
//	    @ExceptionHandler
//	    @ResponseStatus(HttpStatus.NOT_FOUND)
//	    public void handleTodoNotFound(TodoNotFoundException ex) {
//	    }

}
