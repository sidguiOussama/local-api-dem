package com.example.demo.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Sender  implements Serializable{
	@Id @GeneratedValue
	private int id;
	private String userId;
    private String userType;
    
	public Sender() {
		super();
	}
	
	public Sender(int id,String userId, String userType) {
		super();
		this.id = id;
		this.userId = userId;
		this.userType = userType;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "Sender [id=" + id + ", userId=" + userId + ", userType=" + userType + "]";
	}
    
}
