package com.example.longyuan.httpframeworktest.model;

import java.util.List;

public class University{

	private String name;
	private List<Student> students;
	private int id;


	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setStudents(List<Student> students){
		this.students = students;
	}

	public List<Student> getStudents(){
		return students;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}


	@Override
 	public String toString(){
		return 
			"University{" +
			",name = '" + name + '\'' + 
			",students = '" + students + '\'' + 
			",id = '" + id + '\'' +
			"}";
		}
}