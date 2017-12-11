package com.tests4geeks.tutorials.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "userAddress")
public class UserAddress {
@Id
	private Integer id;
	private String countryName;

	public UserAddress(String country) {
		this.countryName = country;
	}

	public UserAddress() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public UserAddress setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getCountryName() {
		return countryName;
	}

	public UserAddress setCountryName(String countryName) {
		this.countryName = countryName;
		return this;
	}

}
