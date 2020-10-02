package com.perscholas.junit5intro.models;

public class Student {

	private int id;
	private String email;
	private String fName;
	private String lName;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student) {
			Student other = (Student) obj;
			boolean sameId = (this.id == other.getId());
			boolean sameEmail = (this.email.equals(other.getEmail()));
			boolean sameFName = (this.fName.equals(other.getfName()));
			boolean sameLName = (this.lName.equals(other.getlName()));
			if (sameId && sameEmail && sameFName && sameLName) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return String.format("ID: %d\nEmail: %s\nFirst Name: %s\nLast Name: %s\nHash Code: %d", 
				this.id, this.email, this.fName, this.lName, this.hashCode());
	}
}