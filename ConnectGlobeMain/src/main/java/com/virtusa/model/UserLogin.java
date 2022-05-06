package com.virtusa.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserLogin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long user_id;
	@Column
	
	private String password;
	public UserLogin() {
		
	}
	public long getUser_id() {
		return user_id;
	}
	public void setuser_id(long user_id) {
		this.user_id = user_id;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}