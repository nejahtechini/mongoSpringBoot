package com.tests4geeks.tutorials.model;

import com.tests4geeks.tutorials.annotation.CascadeSave;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "user")
public class User {
	@Id
	private Integer id;
	@Indexed
	private String name;

	private String teamName;

	private Integer salary;
	@DBRef
    @CascadeSave
	private List<UserAddress> userAddress;
	@DBRef
    @CascadeSave
	private Email email;
	
	public Email getEmail() {
		return email;
	}

	public void setEmail(Email famille) {
		this.email = famille;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public List <UserAddress> getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(List<UserAddress> userAddress) {
		this.userAddress = userAddress;
	}

}

// @Document
// @CompoundIndexes({ @CompoundIndex(name = "email_age", def = "{'email.id' : 1,
// 'age': 1}") })
// public class User {
//
// @Id
// private Integer id;
// @Indexed(direction = IndexDirection.ASCENDING)
// private String name;
// @Indexed(direction = IndexDirection.ASCENDING)
// private Integer age;
//
// @DBRef
// @Field("email")
//
// private UserAddress emailAddress;
//
// @Transient
// private Integer yearOfBirth;
//
// public User() {
// }
//
// public User(String name, Integer age) {
// this.name = name;
// this.age = age;
// }
//
// @PersistenceConstructor
// public User(final String name, @Value("#root.age ?: 0") final Integer age,
// final UserAddress emailAddress) {
// this.name = name;
// this.age = age;
// this.emailAddress = emailAddress;
// }
//
// public Integer getId() {
// return id;
// }
//
// public void setId(final int i) {
// this.id = i;
// }
//
// public String getName() {
// return name;
// }
//
// public void setName(final String name) {
// this.name = name;
// }
//
// public Integer getAge() {
// return age;
// }
//
// public void setAge(final Integer age) {
// this.age = age;
// }
//
// public UserAddress getEmailAddress() {
// return emailAddress;
// }
//
// public void setEmailAddress(final UserAddress emailAddress) {
// this.emailAddress = emailAddress;
// }
//
// public Integer getYearOfBirth() {
// return yearOfBirth;
// }
//
// public void setYearOfBirth(final Integer yearOfBirth) {
// this.yearOfBirth = yearOfBirth;
// }
