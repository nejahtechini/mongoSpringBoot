package com.tests4geeks.tutorials.events;

import org.bson.types.ObjectId;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.DBObject;
import com.tests4geeks.tutorials.model.User;

public class UserReadConverter implements Converter<DBObject, User> {

	  public User convert(DBObject source) {
	    User p = new User();
	    p.setId((Integer) ( source.get("_id")));
	    p.setName((String) ( source.get("name")));
	    DBObject emailObject = source.get(arg0);
	    return p;
	  }
	}