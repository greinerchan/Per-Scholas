package com.perscholas.one_to_one.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "teachers")
public class Teacher {
	@Id
	private int id;
	private String name;
	private double salary;
	@OneToOne
	private Credential credential;
	
	public Teacher() {}
	
	public Teacher(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	public Teacher(int id, String name, double salary, Credential credential) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.credential = credential;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public Credential getCredential() {
		return credential;
	}

	public void setCredential(Credential credential) {
		this.credential = credential;
	}
	
}
