package com.tests4geeks.tutorials.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User {
	@Id
	private Integer id;

	private String name;

	private String teamName;

	private Integer salary;
	@DBRef
	private UserEmail userEmail;

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

	public UserEmail getUserEmail() {
		return userEmail;
	}

	public void setUserAddress(UserEmail userEmail) {
		this.userEmail = userEmail;
	}

}
