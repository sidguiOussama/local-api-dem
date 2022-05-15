package com.example.demo.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Receiver  implements Serializable{
	
	@Id @GeneratedValue
	private int id;
	private String userId;
    private String userType;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn 
    private Message message;
    
    
	public Receiver() {
		super();
	}
	
	public Receiver(int id,String userId, String userType) {
		super();
		this.id = id;
		this.userId = userId;
		this.userType = userType;
	}
	
	public Receiver(int id,String userId, String userType,Message message) {
		super();
		this.id = id;
		this.userId = userId;
		this.userType = userType;
		this.message = message;
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

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Receiver [id=" + id + ", userId=" + userId + ", userType=" + userType + ", message=" + message + "]";
	}
	
	
      
}