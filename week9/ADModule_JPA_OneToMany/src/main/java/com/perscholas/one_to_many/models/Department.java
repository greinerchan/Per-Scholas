package com.perscholas.one_to_many.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Department {
	@Id
	private int id;
	private String name;
	@OneToMany(targetEntity = Teacher.class)
	private List<Teacher> teacherList;

	public Department() {}
	
	public Department(int id, String name, List<Teacher> teacherList) {
		this.id = id;
		this.name = name;
		this.teacherList = teacherList;
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
	
	public List<Teacher> getTeacherList() {
		return teacherList;
	}

	public void setTeacherList(List<Teacher> teacherList) {
		this.teacherList = teacherList;
	}
}
