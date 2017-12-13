package com.tests4geeks.tutorials.service;

import java.util.List;

import com.tests4geeks.tutorials.model.User;

public interface UserService {
	public List<User> getAllUser();
	public User persist( final User user) ;
	public Boolean deleteUser(Integer id);
	public User getUserByName( String name);
}
