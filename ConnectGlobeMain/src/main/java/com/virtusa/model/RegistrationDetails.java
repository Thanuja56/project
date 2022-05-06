package com.virtusa.model;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity

public class RegistrationDetails {
	@Id
	private String first_name;
	private String last_name;
	private Date dob;
	private String gender;
	private String password;
	private String mail_id;
	private String mobile_no;
	private String country;
	private String state;
	private String district;
	private int pincode;
	private int user_id;
	public RegistrationDetails(String first_name, String last_name, Date dob, String gender ,String password,String mail_id, String mobile_no, String country,
			String state, String district, int pincode, int user_id) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.dob = dob;
		this.gender =gender;
		this.password = password;
		this.mail_id = mail_id;
		this.mobile_no = mobile_no;
		this.country = country;
		this.state = state;
		this.district = district;
		this.pincode = pincode;
		this.user_id = user_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
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
	public String getMail_id() {
		return mail_id;
	}
	public void setMail_id(String mail_id) {
		this.mail_id = mail_id;
	}
	public String getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
}
