package com.tests4geeks.tutorials.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tests4geeks.tutorials.model.User;
import com.tests4geeks.tutorials.repository.UserMongoRepository;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserMongoRepository userRepository;

	@Override
	public List<User> getAllUser() {
		List<User> listUser = userRepository.findAll();

		return listUser;
	}

	@Override
	public User persist(final User user) {
//	/*	if (user.getId() == null) {
//			Integer userNumber = (int) userRepository.count();
//			user.setId(userNumber + 1);
//		}*/
		user.getProductList().get(user.getProductList().size()-1);
		return userRepository.save(user);
	}
	@Override
	public Boolean deleteUser(Integer id) {
		User user = userRepository.findById(id);
		userRepository.delete(user);
		return true;
	}
	@Override
	public User getUserByName(String name) {
		User user = userRepository.findByName(name);

		return user;
	}

}
