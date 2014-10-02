package com.directory.query;

public class Person {
	String name;
	String description;
	String telephoneNumber;
	String email;
	
	String givenName;
	String mobile;
	String uid;
	String title;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTelephoneNumber() {
		return telephoneNumber;
	}
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGivenName() {
		return givenName;
	}
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", description=" + description
				+ ", telephoneNumber=" + telephoneNumber + ", email=" + email
				+ ", givenName=" + givenName + ", mobile=" + mobile + ", uid="
				+ uid + ", title=" + title + "]";
	}
	
	

}
