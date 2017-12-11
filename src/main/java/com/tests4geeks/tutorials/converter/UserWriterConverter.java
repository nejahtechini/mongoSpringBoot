package com.tests4geeks.tutorials.converter;
 
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.tests4geeks.tutorials.model.User;
//@Component
public class UserWriterConverter implements Converter<User, DBObject> {
	@Override
public DBObject convert(User user) {
DBObject dbObject = new BasicDBObject();
dbObject.put("_id", user.getId());


dbObject.put("name", user.getName());

if (user.getEmail() != null) {
DBObject emailDbObject = new BasicDBObject();



emailDbObject.put("_id", user.getEmail().getId());

dbObject.put("email", emailDbObject);
}
dbObject.removeField("_class") ;

return dbObject ;}
}