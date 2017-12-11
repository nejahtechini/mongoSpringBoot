package com.tests4geeks.tutorials.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import com.tests4geeks.tutorials.model.User;
@Component
public class UserCascadeSaveMongoEventListener extends AbstractMongoEventListener<Object> {
    @Autowired
    private MongoOperations mongoOperations;
 
    @Override
    public void onBeforeConvert(BeforeConvertEvent<Object> event) { 
        Object source = event.getSource(); 
        if ((source instanceof User) && (((User) source).getUserEmail() != null)) { 
            mongoOperations.save(((User) source).getUserEmail());
        }
    }
}