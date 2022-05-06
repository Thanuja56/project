package com.virtusa.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.DynamicUpdate;
@Entity
@DynamicUpdate
public class UserDetails {
	 @Id
	 
	 private int user_id;
	 @Column
	 private String user_name;
	 private String gender;
	 private String password;
	 private boolean allowedit;
	 @ManyToOne
		@JoinColumn(name = "reportto")
		private UserDetails reportto;
	   
	 public boolean isAllowedit() {
			return allowedit;
		}
		public void setAllowedit(boolean allowedit) {
			this.allowedit = allowedit;
		}
		
		
		public UserDetails getReportto() {
			return reportto;
		}
		public void setReportto(UserDetails reportto) {
			this.reportto = reportto;
		}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id =user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	}
