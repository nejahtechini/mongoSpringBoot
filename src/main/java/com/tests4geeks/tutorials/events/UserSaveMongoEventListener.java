package com.tests4geeks.tutorials.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.AfterDeleteEvent;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.data.mongodb.core.mapping.event.BeforeDeleteEvent;
import org.springframework.data.mongodb.core.mapping.event.BeforeSaveEvent;
import org.springframework.stereotype.Component;

import com.tests4geeks.tutorials.model.Email;
import com.tests4geeks.tutorials.model.User;

@Component

public class UserSaveMongoEventListener extends AbstractMongoEventListener<Object> {
	
	@Autowired
	private MongoOperations mongoOperations;

//	@Override
//	public void onBeforeConvert(BeforeConvertEvent<Object> event) {
//		Object source = event.getSource();
//		if ((source instanceof User) && (((User) source).getUserAddress() != null)) {
//
//			((User) source).getUserAddress().forEach(item -> mongoOperations.save(item));
//
//		}
//		if ((source instanceof User) && (((User) source).getEmail() != null)) {
//			mongoOperations.save(((User) source).getEmail());
//
//		}
//	}
//	
	@Override
	public void  onBeforeSave(BeforeSaveEvent<Object> event) {
		Object source = event.getSource();
		if ((source instanceof User) && (((User) source).getUserAddress() != null)) {

			((User) source).getUserAddress().forEach(item -> mongoOperations.save(item));

		}
		if ((source instanceof User) && (((User) source).getEmail() != null)) {
			mongoOperations.save(((User) source).getEmail());

		}
	}
	
	
	
}