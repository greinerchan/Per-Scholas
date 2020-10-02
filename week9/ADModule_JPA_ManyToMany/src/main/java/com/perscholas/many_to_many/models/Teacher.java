package com.perscholas.many_to_many.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "teachers")
public class Teacher {
	@Id
	private int teacherId;
	private String name;
	private double salary;
	@ManyToMany
	@JoinTable(
			  name = "teachers_departments", 
			  joinColumns = @JoinColumn(name = "teacherId"), 
			  inverseJoinColumns = @JoinColumn(name = "departmentId"))
	private List<Department> teacherDepartments;

	public Teacher() {
		this.teacherDepartments = new ArrayList<>();
	}
	
	public Teacher(int teacherId, String name, double salary) {
		this();
		this.teacherId = teacherId;
		this.name = name;
		this.salary = salary;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
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
	
	public List<Department> getTeacherDepartments() {
		return teacherDepartments;
	}

	public void setTeacherDepartments(List<Department> teacherDepartments) {
		this.teacherDepartments = teacherDepartments;
	}
}
