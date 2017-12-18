package com.tests4geeks.tutorials.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.tests4geeks.tutorials.annotation.CascadeSave;

@Document(collection = "user")
public class User {
	@Id
	private BigInteger id;
	  

    private String name;

    private String teamName;

    private Integer salary;

    private UserAddress userAddress ;
   
//    @DBRef
//    @CascadeSave
    private List<Product> productList  ;


	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
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

	public UserAddress getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(UserAddress address) {
		this.userAddress = address;
	}


	
}
