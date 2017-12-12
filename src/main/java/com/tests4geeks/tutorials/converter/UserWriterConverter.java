package com.tests4geeks.tutorials.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBRef;
import com.tests4geeks.tutorials.model.User;

@Component
public class UserWriterConverter implements Converter<User, DBObject> {

	@Override
	public BasicDBObject convert(User user) {

		BasicDBObject dbObject = new BasicDBObject();
		List<DBRef> dbRefList = new ArrayList<>();

		dbObject.put("_id", user.getId());

		dbObject.put("name", user.getName());

		if (user.getUserEmail() != null) {

			DBObject emailDbObject = new BasicDBObject();
			emailDbObject.put("_id", user.getUserEmail().getId());
			dbObject.put("userEmail", emailDbObject);
		}

		if (user.getUserAddress() != null) {

			user.getUserAddress().forEach(item -> {
				DBRef myDbRef = new DBRef("userAddress", item.getId());
				dbRefList.add(myDbRef);
			});

		}

		dbObject.put("userAddress", dbRefList);

		return dbObject;
	}
}