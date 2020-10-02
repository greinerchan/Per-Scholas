package com.perscholas.jpa_orm_lesson.models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
@NamedQuery(query = "SELECT e FROM Employee e WHERE e.eid = :id", name = "Find Employee By ID")
public class Employee {
	@Id
	@Column(name = "eid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int eid;
	@Basic
	@Column(name = "ename")
	private String ename;
	@Basic
	@Column(name = "salary")
	private double salary;
	@Basic
	@Column(name = "deg")
	private String deg;
	
	public Employee() {}
	
	public Employee(String ename, double salary, String deg) {
		this.ename = ename;
		this.salary = salary;
		this.deg = deg;
	}
	
	public Employee(int eid, String ename, double salary, String deg) {
		this.eid = eid;
		this.ename = ename;
		this.salary = salary;
		this.deg = deg;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDeg() {
		return deg;
	}

	public void setDeg(String deg) {
		this.deg = deg;
	}
	
	@Override
	public String toString() {
		return "ID: " + this.eid + 
				"\nName: " + this.ename + 
				"\nSalary: " + this.salary +
				"\nDegree: " + this.deg;
	}
}