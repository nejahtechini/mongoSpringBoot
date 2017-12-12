package com.tests4geeks.tutorials.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.tests4geeks.tutorials.model.Email;
import com.tests4geeks.tutorials.model.User;
import com.tests4geeks.tutorials.repository.EmailMongoRepository;

//@Component
public class UserReadConverter implements Converter<DBObject, User> {
	@Autowired
	private EmailMongoRepository mongoOperations;

	public User convert(DBObject source) {
		User p = new User();
		p.setId((Integer) (source.get("_id")));
		p.setName((String) (source.get("name")));
		DBObject emailDbObject = (DBObject) source.get("userEmail");
		Email UserEmail = new Email();
		UserEmail.setId((Integer) (emailDbObject.get("_id")));
		// UserEmail=mongoOperations.findById(2) ;
		DBObject addressDbObject = (DBObject) source.get("userAddress");
		addressDbObject.toMap().forEach((k, v) -> {

	

		});
		return p;
	}
}